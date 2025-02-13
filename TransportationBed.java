import java.util.Stack;

public class TransportationBed {
    private final int loadSize;
    private final Stack<Car> loadedCars;

    public TransportationBed(int loadSize) {
        this.loadSize = loadSize;
        loadedCars = new Stack<Car>();
    }

    public int getLoadSize() {
        return loadSize;
    }

    public Stack<Car>getLoadedCars() {
        return loadedCars;
    }

    public int getVehicleCount() {
        return loadedCars.size();
    }

    public void load(Car car) {
        if (loadedCars.size() < loadSize)
            loadedCars.push(car);
        else
            System.out.println("Truck is full");
    }

    public Car unload() {
        if (!loadedCars.isEmpty()) {
            Car car = loadedCars.pop();
            return car;
        }
        else {
            System.out.println("Truck is empty");
            return null;
        }
    }

}
