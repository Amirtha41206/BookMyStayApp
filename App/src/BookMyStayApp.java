import java.util.*;

// Room Domain Model
class Room {
    private String type;
    private double price;
    private List<String> amenities;

    public Room(String type, double price, List<String> amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: ₹" + price);
        System.out.println("Amenities: " + amenities);
        System.out.println("--------------------------");
    }
}

// Inventory (State Holder)
class Inventory {
    private Map<String, Integer> roomAvailability = new HashMap<>();

    public void addRoom(String type, int count) {
        roomAvailability.put(type, count);
    }

    // Read-only access
    public int getAvailability(String type) {
        return roomAvailability.getOrDefault(type, 0);
    }

    public Map<String, Integer> getAllAvailability() {
        return Collections.unmodifiableMap(roomAvailability); // defensive
    }
}

// Search Service (Read-only)
class SearchService {
    private Inventory inventory;
    private Map<String, Room> roomMap;

    public SearchService(Inventory inventory, Map<String, Room> roomMap) {
        this.inventory = inventory;
        this.roomMap = roomMap;
    }

    public void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:\n");

        for (String type : inventory.getAllAvailability().keySet()) {

            int available = inventory.getAvailability(type);

            // Validation logic: only show available rooms
            if (available > 0) {
                Room room = roomMap.get(type);

                if (room != null) { // defensive check
                    room.displayDetails();
                    System.out.println("Available Count: " + available);
                    System.out.println("==========================");
                }
            }
        }
    }
}

// Main Class
public class BookMyStayApp {
    public static void main(String[] args) {

        // Step 1: Create inventory
        Inventory inventory = new Inventory();
        inventory.addRoom("Single", 3);
        inventory.addRoom("Double", 0); // unavailable
        inventory.addRoom("Suite", 2);

        // Step 2: Create room details
        Map<String, Room> roomMap = new HashMap<>();

        roomMap.put("Single", new Room(
                "Single", 2000,
                Arrays.asList("WiFi", "TV", "AC")));

        roomMap.put("Double", new Room(
                "Double", 3500,
                Arrays.asList("WiFi", "TV", "AC", "Mini Bar")));

        roomMap.put("Suite", new Room(
                "Suite", 6000,
                Arrays.asList("WiFi", "TV", "AC", "Jacuzzi", "Balcony")));

        // Step 3: Search Service
        SearchService searchService = new SearchService(inventory, roomMap);

        // Step 4: Perform search (Read-only)
        searchService.searchAvailableRooms();
    }
}