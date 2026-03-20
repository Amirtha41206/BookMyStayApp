import java.util.*;

// Add-On Service
class AddOnService {
    private String name;
    private double cost;

    public AddOnService(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void display() {
        System.out.println("Service: " + name + " | Cost: ₹" + cost);
    }
}

// Reservation (from previous use cases)
class Reservation {
    private String reservationId;
    private String guestName;

    public Reservation(String reservationId, String guestName) {
        this.reservationId = reservationId;
        this.guestName = guestName;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    // Map<ReservationID, List of Services>
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {

        List<AddOnService> services =
                serviceMap.getOrDefault(reservationId, new ArrayList<>());

        services.add(service);
        serviceMap.put(reservationId, services);

        System.out.println("Added service '" + service.getName() +
                "' to reservation " + reservationId);
    }

    // Display services
    public void displayServices(String reservationId) {
        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services for reservation " + reservationId);
            return;
        }

        System.out.println("\nServices for Reservation " + reservationId + ":");

        for (AddOnService s : services) {
            s.display();
        }
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {
        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null) return 0;

        double total = 0;
        for (AddOnService s : services) {
            total += s.getCost();
        }
        return total;
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        // Step 1: Create reservation (already confirmed in UC6)
        Reservation reservation = new Reservation("RES-101", "Alice");

        // Step 2: Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService wifi = new AddOnService("Premium WiFi", 200);
        AddOnService spa = new AddOnService("Spa Access", 1500);

        // Step 3: Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Step 4: Add services
        manager.addService(reservation.getReservationId(), breakfast);
        manager.addService(reservation.getReservationId(), wifi);
        manager.addService(reservation.getReservationId(), spa);

        // Step 5: Display services
        manager.displayServices(reservation.getReservationId());

        // Step 6: Total cost
        double total = manager.calculateTotalCost(reservation.getReservationId());
        System.out.println("\nTotal Add-On Cost: ₹" + total);
    }
}