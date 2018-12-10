package task01.service;

import task01.Consumer;
import task01.MyQueue;
import task01.Producer;

public class BookingServiceImpl implements IBookingService {
    private final MyQueue myQueue;

    public BookingServiceImpl() {
        myQueue = new MyQueue();
    }

    public void runProducers(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread producer = new Thread(new Producer(myQueue, i));
            producer.start();
        }
    }

    public void runConsumers(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread consumer = new Thread(new Consumer(myQueue, i));
            consumer.start();
        }
    }
}
