package task01;

import task01.service.BookingServiceImpl;
import task01.service.IBookingService;

import static task01.utils.constants.BookingConstants.MAX_CONSUMER_THREADS;
import static task01.utils.constants.BookingConstants.MAX_PRODUCER_THREADS;

public class Runner {
    public static void main(String[] args) {
        IBookingService service = new BookingServiceImpl();
        service.runConsumers(MAX_CONSUMER_THREADS);
        service.runProducers(MAX_PRODUCER_THREADS);
    }
}
