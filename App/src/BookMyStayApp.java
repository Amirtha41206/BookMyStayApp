import java.util.*;

// Shared Inventory Class
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 2);
        inventory.put("Double", 1);
    }

    // Synchronized method (critical section)
    public synchronized boolean bookRoom(String roomType, String threadName) {
        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            System.out.println(threadName + " booking " + roomType + " Room...");

            // simulate delay (to expose race condition if not synchronized)
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            inventory.put(roomType, available - 1);
            System.out.println("Booking successful: " + roomType + " Room");
            return true;
        } else {
            System.out.println("Booking failed: No " + roomType + " rooms available");
            return false;
        }
    }

    public void displayInventory() {
        System.out.println("\nFinal Inventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + " Room : " + inventory.get(key));
        }
    }
}

// Booking Task (Thread)
class BookingTask implements Runnable {
    private RoomInventory inventory;
    private String roomType;

    public BookingTask(RoomInventory inventory, String roomType) {
        this.inventory = inventory;
        this.roomType = roomType;
    }

    @Override
    public void run() {
        inventory.bookRoom(roomType, Thread.currentThread().getName());
    }
}

// Main Class
public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Book My Stay - Version 2.13.11\n");

        RoomInventory inventory = new RoomInventory();

        System.out.println("Simulating concurrent bookings...\n");

        // Create multiple threads (simulating users)
        Thread t1 = new Thread(new BookingTask(inventory, "Single"), "Thread-1");
        Thread t2 = new Thread(new BookingTask(inventory, "Single"), "Thread-2");
        Thread t3 = new Thread(new BookingTask(inventory, "Double"), "Thread-3");
        Thread t4 = new Thread(new BookingTask(inventory, "Single"), "Thread-4");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {}

        // Display final inventory
        inventory.displayInventory();

        System.out.println("\nSystem state remains consistent (no double booking).");
    }
}