import java.util.*;

// Reservation (Represents booking request)
class Reservation {
    private String guestName;
    private String roomType;
    private int roomsRequested;

    public Reservation(String guestName, String roomType, int roomsRequested) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomsRequested = roomsRequested;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomsRequested() {
        return roomsRequested;
    }

    public void display() {
        System.out.println("Guest: " + guestName +
                ", Room Type: " + roomType +
                ", Rooms Requested: " + roomsRequested);
    }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for " + reservation.getGuestName());
    }

    // View all requests
    public void displayQueue() {
        System.out.println("\nCurrent Booking Queue:");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }

    // Peek next request (no removal)
    public Reservation peekNext() {
        return queue.peek();
    }

    // Process request (dequeue)
    public Reservation processRequest() {
        return queue.poll();
    }
}

// Main Class
public class BookMyStayApp{

    public static void main(String[] args) {

        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Step 1: Guests submit requests
        requestQueue.addRequest(new Reservation("Alice", "Single", 1));
        requestQueue.addRequest(new Reservation("Bob", "Double", 2));
        requestQueue.addRequest(new Reservation("Charlie", "Suite", 1));

        // Step 2: Display queue (FIFO order)
        requestQueue.displayQueue();

        // Step 3: Show next request (without removing)
        System.out.println("\nNext request to process:");
        Reservation next = requestQueue.peekNext();
        if (next != null) next.display();

        // Step 4: Process requests (simulate allocation system later)
        System.out.println("\nProcessing requests:");

        while (true) {
            Reservation processed = requestQueue.processRequest();
            if (processed == null) break;

            System.out.println("Processing request:");
            processed.display();
        }

        // Step 5: Queue empty
        requestQueue.displayQueue();
    }
}