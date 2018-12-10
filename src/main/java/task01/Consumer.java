package task01;

import task01.model.BookingRequest;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static task01.utils.constants.BookingConstants.*;

public class Consumer implements Runnable {
    private final MyQueue myQueue;
    private final String consumerName;

    public Consumer(MyQueue myQueue, int consumerNumber) {
        this.myQueue = myQueue;
        consumerName = this.getClass().getSimpleName() + consumerNumber;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            int consumedCount = CONSUMED_REQUESTS_COUNT.getAndIncrement() + 1;

            if (consumedCount > MAX_CONSUMED_REQUEST) {
                LOGGER.debug("number of consumed request exceeded count:{}", consumedCount);
                return;
            }

            BookingRequest nextRequestFromQueue = myQueue.get();
            LOGGER.info("{} consumed:{} (request:{})", consumerName, nextRequestFromQueue, consumedCount);

            try {
                sleep(CONSUMER_SLEEP_TIME);
                LOGGER.info("{} processed:{} (request:{})", consumerName, nextRequestFromQueue, consumedCount);
            } catch (InterruptedException e) {
                LOGGER.error("{} interrupted", consumerName, e);
                currentThread().interrupt();
            }
        }
    }
}
