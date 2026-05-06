package hotelReservation;

public class Room {
    private String roomNumber;
    private String category;
    private boolean isBooked;

    public Room(String roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { this.isBooked = booked; }
}
