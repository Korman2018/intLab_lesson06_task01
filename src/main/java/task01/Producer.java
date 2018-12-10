package task01;

import task01.model.BookingRequest;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static java.util.concurrent.ThreadLocalRandom.current;
import static task01.utils.constants.BookingConstants.*;
import static task01.utils.generator.BookingRequestGenerator.generate;

public class Producer implements Runnable {
    private final MyQueue myQueue;
    private final String producerName;

    public Producer(MyQueue myQueue, int producerNumber) {
        this.myQueue = myQueue;
        producerName = this.getClass().getSimpleName() + producerNumber;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            int count = GENERATED_REQUESTS_COUNT.getAndIncrement() + 1;

            if (count > MAX_REQUEST) {
                LOGGER.debug("request number:{} -> stop producing", count);
                return;
            }

            try {
                sleep(current().nextLong(MIN_PRODUCER_SLEEP_TIME_MS, MAX_PRODUCER_SLEEP_TIME_MS));
            } catch (InterruptedException e) {
                LOGGER.error("producer is interrupted(requests number:{}", count, e);
                currentThread().interrupt();
            }

            BookingRequest generatedRequest = generate();
            LOGGER.info("{} sent:{}  (request:{})", producerName, generatedRequest, count);
            myQueue.put(generatedRequest);
        }
    }
}
