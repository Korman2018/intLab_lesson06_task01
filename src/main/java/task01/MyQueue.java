package task01;

import task01.model.BookingRequest;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.currentThread;
import static task01.utils.constants.BookingConstants.CAPACITY;
import static task01.utils.constants.BookingConstants.LOGGER;

public class MyQueue {
    private final Queue<BookingRequest> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void put(BookingRequest request) {
        while (isQueueFull()) {
            try {
                LOGGER.debug("queue is full, waiting to consume");
                wait();
            } catch (InterruptedException e) {
                LOGGER.error("queue put interrupt thread:{}", currentThread(), e);
                currentThread().interrupt();
            }
        }

        queue.add(request);
        LOGGER.debug("queue(size after put:{}) put:{}", queue.size(), request);
        notifyAll();
    }

    public synchronized BookingRequest get() {
        while (queue.isEmpty()) {
            try {
                LOGGER.debug("queue is empty, waiting to produce");
                wait();
            } catch (InterruptedException e) {
                LOGGER.error("queue get interrupt thread:{}", currentThread(), e);
                currentThread().interrupt();
            }
        }

        BookingRequest request = queue.remove();
        LOGGER.debug("queue(size after remove:{}) get:{}", queue.size(), request);
        notifyAll();

        return request;
    }

    private boolean isQueueFull() {
        return queue.size() == CAPACITY;
    }
}
