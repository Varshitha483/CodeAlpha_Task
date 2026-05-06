package hotelReservation;

import java.time.LocalDate;

public class Booking {
    private static int counter = 1;
    private String bookingId;
    private String customerName;
    private String roomNumber;
    private double amountPaid;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking(String customerName, String roomNumber, double amountPaid,
                   LocalDate checkIn, LocalDate checkOut) {
        this.bookingId = "B" + (counter++);
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.amountPaid = amountPaid;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public String getRoomNumber() { return roomNumber; }
    public double getAmountPaid() { return amountPaid; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
}
