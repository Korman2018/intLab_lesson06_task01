package task01.service;

public interface IBookingService {
    void runProducers(int numberOfThreads);

    void runConsumers(int numberOfThreads);
}
