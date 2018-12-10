package task01.model;

import java.time.LocalDate;

public class BookingRequest {
    private String hotel;
    private int price;
    private LocalDate date;

    public BookingRequest(String hotel, int price, LocalDate date) {
        this.hotel = hotel;
        this.price = price;
        this.date = date;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "'" + hotel + "' price:" + price + " date:" + date;
    }
}
