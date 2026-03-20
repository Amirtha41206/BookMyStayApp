import java.util.*;

// Reservation Model
class Reservation {
    String reservationId;
    String guestName;
    String roomType;
    int count;

    public Reservation(String reservationId, String guestName, String roomType, int count) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.count = count;
    }

    public void display() {
        System.out.println("Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType +
                " | Count: " + count);
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

    public boolean reduceRoom(String type, int count) {
        int available = getAvailability(type);

        if (available < count) {
            return false;
        }

        inventory.put(type, available - count);
        return true;
    }
}

// Booking History (List maintains order)
class BookingHistory {
    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(history); // read-only
    }
}

// Report Service
class BookingReportService {

    public void displayAllBookings(List<Reservation> list) {
        System.out.println("\n--- Booking History ---");

        for (Reservation r : list) {
            r.display();
        }
    }

    public void generateSummary(List<Reservation> list) {

        System.out.println("\n--- Booking Summary ---");

        int totalBookings = list.size();
        int totalRooms = 0;

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : list) {
            totalRooms += r.count;

            roomTypeCount.put(
                    r.roomType,
                    roomTypeCount.getOrDefault(r.roomType, 0) + r.count
            );
        }

        System.out.println("Total Reservations: " + totalBookings);
        System.out.println("Total Rooms Booked: " + totalRooms);

        System.out.println("\nRoom Type Distribution:");
        for (String type : roomTypeCount.keySet()) {
            System.out.println(type + " -> " + roomTypeCount.get(type));
        }
    }
}

// Booking Service (connects everything)
class BookingService {

    private InventoryService inventory;
    private BookingHistory history;

    public BookingService(InventoryService inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
    }

    public void processReservation(Reservation r) {

        System.out.println("\nProcessing: " + r.guestName);

        boolean success = inventory.reduceRoom(r.roomType, r.count);

        if (!success) {
            System.out.println("Booking Failed for " + r.guestName);
            return;
        }

        System.out.println("Booking Confirmed for " + r.guestName);

        // Store in history (IMPORTANT)
        history.addReservation(r);
    }
}

// MAIN CLASS
public class BookMyStayApp {

    public static void main(String[] args) {

        // Setup
        InventoryService inventory = new InventoryService();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 2);

        BookingHistory history = new BookingHistory();
        BookingService service = new BookingService(inventory, history);

        // Bookings
        service.processReservation(new Reservation("RES-1", "Alice", "Single", 1));
        service.processReservation(new Reservation("RES-2", "Bob", "Double", 2));
        service.processReservation(new Reservation("RES-3", "Charlie", "Single", 2)); // fail

        // Reporting
        BookingReportService report = new BookingReportService();

        report.displayAllBookings(history.getAllReservations());
        report.generateSummary(history.getAllReservations());
    }
}