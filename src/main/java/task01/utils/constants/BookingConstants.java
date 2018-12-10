package task01.utils.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class BookingConstants {
    // common section
    public static final Logger LOGGER = LoggerFactory.getLogger("Booking");

    // consumer section
    public static final long CONSUMER_SLEEP_TIME = 5000;
    public static final int MAX_CONSUMED_REQUEST = 15;
    public static final int MAX_CONSUMER_THREADS = 6;
    public static final AtomicInteger CONSUMED_REQUESTS_COUNT = new AtomicInteger(0);

    //producer section
    public static final int MAX_REQUEST = 15;
    public static final long MIN_PRODUCER_SLEEP_TIME_MS = 100;
    public static final long MAX_PRODUCER_SLEEP_TIME_MS = 500;
    public static final int MAX_PRODUCER_THREADS = 3;
    public static final AtomicInteger GENERATED_REQUESTS_COUNT = new AtomicInteger(0);

    //MyQueue section
    public static final int CAPACITY = 5;

    // request generator section
    public static final int MIN_PRICE = 200;
    public static final int MAX_PRICE = 10000;
    public static final int PLUS_MONTHS = 6;
    public static final String[] HOTELS = {
            "The Oberoi Udaivilas",
            "Baros Maldives",
            "Armani Hotel Dubai",
            "Mriya Resort & Spa",
            "Dukes",
            "Peninsula",
            "Finch Bay Galapagos Hotel",
            "The Venetian Macao Resort Hotel",
            "San Clemente Palace Kempinski Venice",
            "Angel’s Marmaris"
    };

    private BookingConstants() {
    }
}
