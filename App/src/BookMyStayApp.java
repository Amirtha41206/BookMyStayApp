import java.util.*;

// Reservation (from UC5)
class Reservation {
    String guestName;
    String roomType;
    int count;

    public Reservation(String guestName, String roomType, int count) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.count = count;
    }
}

// Inventory Service
class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceRoom(String type, int count) {
        int available = getAvailability(type);
        inventory.put(type, available - count);
    }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.offer(r);
    }

    public Reservation getNextRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Booking Service (Core Logic)
class BookingService {

    private InventoryService inventory;

    // Track allocated room IDs (uniqueness)
    private Set<String> allocatedRoomIds = new HashSet<>();

    // Map room type -> assigned room IDs
    private Map<String, Set<String>> roomAllocations = new HashMap<>();

    public BookingService(InventoryService inventory) {
        this.inventory = inventory;
    }

    // Generate unique room ID
    private String generateRoomId(String type) {
        String id;
        do {
            id = type.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
        } while (allocatedRoomIds.contains(id));

        allocatedRoomIds.add(id);
        return id;
    }

    // Process booking
    public void processReservation(Reservation r) {

        System.out.println("\nProcessing booking for " + r.guestName);

        int available = inventory.getAvailability(r.roomType);

        if (available < r.count) {
            System.out.println("Booking Failed: Not enough rooms available for " + r.roomType);
            return;
        }

        // Allocate rooms
        Set<String> assignedRooms = roomAllocations.getOrDefault(r.roomType, new HashSet<>());

        for (int i = 0; i < r.count; i++) {
            String roomId = generateRoomId(r.roomType);
            assignedRooms.add(roomId);
            System.out.println("Allocated Room ID: " + roomId);
        }

        // Update map
        roomAllocations.put(r.roomType, assignedRooms);

        // Update inventory immediately (atomic logic)
        inventory.reduceRoom(r.roomType, r.count);

        System.out.println("Booking Confirmed for " + r.guestName);
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Step 1: Inventory setup
        InventoryService inventory = new InventoryService();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 1);

        // Step 2: Queue setup
        BookingRequestQueue queue = new BookingRequestQueue();
        queue.addRequest(new Reservation("Alice", "Single", 1));
        queue.addRequest(new Reservation("Bob", "Single", 2)); // will fail
        queue.addRequest(new Reservation("Charlie", "Double", 1));

        // Step 3: Booking service
        BookingService service = new BookingService(inventory);

        // Step 4: Process queue (FIFO)
        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            service.processReservation(r);
        }
    }
}