import java.io.*;
import java.util.*;

// Booking class (Serializable)
class Booking implements Serializable {
    String bookingId;
    String roomType;

    Booking(String bookingId, String roomType) {
        this.bookingId = bookingId;
        this.roomType = roomType;
    }
}

// Room Inventory (Serializable)
class RoomInventory implements Serializable {
    Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 2);
        inventory.put("Double", 1);
    }
}

// Persistence Service
class PersistenceService {

    private static final String FILE_NAME = "hotel_data.ser";

    // Save data to file
    public static void saveData(RoomInventory inventory, Map<String, Booking> bookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            oos.writeObject(bookings);
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    // Load data from file
    public static Object[] loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            RoomInventory inventory = (RoomInventory) ois.readObject();
            Map<String, Booking> bookings = (Map<String, Booking>) ois.readObject();
            System.out.println("Data restored successfully");
            return new Object[]{inventory, bookings};
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh...");
            return null;
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Book My Stay - Version 2.13.12\n");

        RoomInventory inventory;
        Map<String, Booking> bookings;

        // Load previous state
        Object[] data = PersistenceService.loadData();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            bookings = (Map<String, Booking>) data[1];
        } else {
            inventory = new RoomInventory();
            bookings = new HashMap<>();
        }

        // Simulate booking
        bookings.put("B101", new Booking("B101", "Single"));
        bookings.put("B102", new Booking("B102", "Double"));

        System.out.println("\nSaving system state...");
        PersistenceService.saveData(inventory, bookings);

        // Display recovered data
        System.out.println("\nRecovered Inventory:");
        for (String key : inventory.inventory.keySet()) {
            System.out.println(key + " Room : " + inventory.inventory.get(key));
        }

        System.out.println("\nRecovered Bookings:");
        for (String key : bookings.keySet()) {
            Booking b = bookings.get(key);
            System.out.println(b.bookingId + " -> " + b.roomType + " Room");
        }

        System.out.println("\nSystem resumed with previous state");
    }
}