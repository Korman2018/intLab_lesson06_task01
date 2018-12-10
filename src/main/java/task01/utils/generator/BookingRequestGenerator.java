package task01.utils.generator;

import task01.model.BookingRequest;

import java.time.LocalDate;

import static java.util.concurrent.ThreadLocalRandom.current;
import static task01.utils.constants.BookingConstants.*;

public class BookingRequestGenerator {
    private BookingRequestGenerator() {
    }

    public static BookingRequest generate() {
        return new BookingRequest(generateHotel(), generatePrice(), generateDate());
    }

    private static String generateHotel() {
        int randomIndex = current().nextInt(HOTELS.length);
        return HOTELS[randomIndex];
    }

    private static int generatePrice() {
        return current().nextInt(MIN_PRICE, MAX_PRICE);
    }

    private static LocalDate generateDate() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(PLUS_MONTHS);
        long randomEpochDay = current().nextLong(startDate.toEpochDay(), endDate.toEpochDay());
        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
