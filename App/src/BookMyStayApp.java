import java.util.*;

class Booking {
    String bookingId;
    String roomType;
    String roomId;
    boolean isCancelled;

    Booking(String bookingId, String roomType, String roomId) {
        this.bookingId = bookingId;
        this.roomType = roomType;
        this.roomId = roomId;
        this.isCancelled = false;
    }
}

class HotelSystem {

    // Inventory: Room Type → Available Count
    Map<String, Integer> inventory = new HashMap<>();

    // Booking storage
    Map<String, Booking> bookings = new HashMap<>();

    // Stack for rollback (LIFO)
    Stack<String> rollbackStack = new Stack<>();

    // Initialize inventory
    public HotelSystem() {
        inventory.put("Single", 2);
        inventory.put("Double", 2);
    }

    // Booking method (for testing)
    public void createBooking(String bookingId, String roomType, String roomId) {
        if (inventory.get(roomType) > 0) {
            inventory.put(roomType, inventory.get(roomType) - 1);
            bookings.put(bookingId, new Booking(bookingId, roomType, roomId));
            System.out.println("Booking confirmed: " + bookingId);
        } else {
            System.out.println("No rooms available!");
        }
    }

    // 🔴 Use Case 10: Cancellation with Rollback
    public void cancelBooking(String bookingId) {

        // Step 1: Validate booking
        if (!bookings.containsKey(bookingId)) {
            System.out.println("Invalid booking ID!");
            return;
        }

        Booking booking = bookings.get(bookingId);

        if (booking.isCancelled) {
            System.out.println("Booking already cancelled!");
            return;
        }

        // Step 2: Push roomId into rollback stack
        rollbackStack.push(booking.roomId);

        // Step 3: Restore inventory
        String roomType = booking.roomType;
        inventory.put(roomType, inventory.get(roomType) + 1);

        // Step 4: Update booking status
        booking.isCancelled = true;

        // Step 5: Confirmation
        System.out.println("Booking cancelled successfully: " + bookingId);
        System.out.println("Room restored: " + rollbackStack.peek());
    }

    // Display current state
    public void displayStatus() {
        System.out.println("\nInventory: " + inventory);
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        HotelSystem system = new HotelSystem();

        // Sample bookings
        system.createBooking("B101", "Single", "R1");
        system.createBooking("B102", "Double", "R2");

        system.displayStatus();

        // Cancel booking
        system.cancelBooking("B101");

        system.displayStatus();
    }
}