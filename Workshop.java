import java.util.HashMap;

public class Workshop<T extends Car> {
    private final int capacity; // Max antal bilar verkstaden kan ta
    private HashMap<T,T> vehicles;

    public Workshop(int capacity) {
        this.capacity = capacity;
        vehicles = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<T,T> getVehicles() {
        return vehicles;
    }

    // Lägg till ett fordon i verkstaden
    public void addVehicle(T vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.put(vehicle, vehicle);
            System.out.println(vehicle + " added to the workshop.");
        } else {
            System.out.println("Workshop is full. " + vehicle);
        }
    }

    // Ta bort ett fordon från verkstaden
    public T removeVehicle(T t) {
        if (!vehicles.isEmpty()) {
            T vehicle = vehicles.remove(t);
            System.out.println(vehicle.toString() + " removed from the workshop.");
            return vehicle;
        } else {
            System.out.println("No vehicles in the workshop.");
            return null;
        }
    }

    // Visa alla fordon i verkstaden
    public void listVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the workshop.");
        } else {
            System.out.println("Vehicles in the workshop:");
            for (T vehicle : vehicles.values()) {
                System.out.println("- " + vehicle.getModelName());
            }
        }
    }

    public int countVehicles(){
        return vehicles.size();
    }

}
