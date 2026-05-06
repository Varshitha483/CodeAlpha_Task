package hotelReservation;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        loadRooms();
        loadBookings();
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n==== Hotel Reservation System ====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. View Revenue Report");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> bookRoom(sc);
                case 3 -> cancelBooking(sc);
                case 4 -> viewBookings();
                case 5 -> viewRevenueReport();
                case 6 -> {
                    saveBookings();
                    System.out.println("Exiting... Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }

            if (running) {
                System.out.print("\nDo you want to continue? (Y/N): ");
                String ans = sc.nextLine();
                if (!ans.equalsIgnoreCase("Y")) {
                    saveBookings();
                    System.out.println("Goodbye!");
                    running = false;
                }
            }
        }
    }

    // === Room Management ===
    private static void loadRooms() {
        rooms.add(new Room("101", "Standard"));
        rooms.add(new Room("102", "Standard"));
        rooms.add(new Room("201", "Deluxe"));
        rooms.add(new Room("202", "Deluxe"));
        rooms.add(new Room("301", "Suite"));
    }

    private static void viewAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room " + room.getRoomNumber() +
                        " (" + room.getCategory() + ") - ₹" + calculatePrice(room.getCategory()));
                found = true;
            }
        }
        if (!found) System.out.println("No available rooms.");
    }

    private static double calculatePrice(String category) {
        return switch (category) {
            case "Standard" -> 2000.0;
            case "Deluxe" -> 3500.0;
            case "Suite" -> 5000.0;
            default -> 0;
        };
    }

    // === Booking Management ===
    private static void bookRoom(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        viewAvailableRooms();
        System.out.print("Enter room number to book: ");
        String roomNumber = sc.nextLine();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && !room.isBooked()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not available or invalid.");
            return;
        }

        System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine());
        System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine());

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Check-out date must be after check-in.");
            return;
        }

        double amount = calculatePrice(selectedRoom.getCategory());
        System.out.println("Simulated Payment: ₹" + amount);
        System.out.println("Payment successful!");

        selectedRoom.setBooked(true);
        Booking newBooking = new Booking(name, roomNumber, amount, checkIn, checkOut);
        bookings.add(newBooking);

        System.out.println("\n✅ Booking Confirmed!");
        System.out.println("Booking ID: " + newBooking.getBookingId());
        System.out.println("Name: " + name);
        System.out.println("Room: " + roomNumber);
        System.out.println("Check-in: " + checkIn + ", Check-out: " + checkOut);
        System.out.println("Amount Paid: ₹" + amount);
    }

    private static void cancelBooking(Scanner sc) {
        System.out.print("Enter Booking ID to cancel: ");
        String id = sc.nextLine();

        Booking toRemove = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(id)) {
                toRemove = booking;
                break;
            }
        }

        if (toRemove != null) {
            bookings.remove(toRemove);
            for (Room room : rooms) {
                if (room.getRoomNumber().equals(toRemove.getRoomNumber())) {
                    room.setBooked(false);
                    break;
                }
            }
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    private static void viewBookings() {
        System.out.println("\n--- Booking Details ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                System.out.println("ID: " + b.getBookingId() + " | Name: " + b.getCustomerName() +
                        " | Room: " + b.getRoomNumber() + " | Paid: ₹" + b.getAmountPaid() +
                        " | Check-in: " + b.getCheckIn() + " | Check-out: " + b.getCheckOut());
            }
        }
    }

    private static void viewRevenueReport() {
        double total = 0;
        for (Booking b : bookings) {
            total += b.getAmountPaid();
        }
        System.out.println("\n--- Revenue Report ---");
        System.out.println("Total Bookings: " + bookings.size());
        System.out.println("Total Revenue: ₹" + total);
    }

    // === File Persistence ===
    private static void loadBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Booking b = new Booking(parts[0], parts[1], Double.parseDouble(parts[2]),
                        LocalDate.parse(parts[3]), LocalDate.parse(parts[4]));
                bookings.add(b);
                for (Room r : rooms) {
                    if (r.getRoomNumber().equals(parts[1])) {
                        r.setBooked(true);
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    private static void saveBookings() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bookings.txt"))) {
            for (Booking b : bookings) {
                bw.write(b.getCustomerName() + "," + b.getRoomNumber() + "," + b.getAmountPaid()
                        + "," + b.getCheckIn() + "," + b.getCheckOut() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }
}
