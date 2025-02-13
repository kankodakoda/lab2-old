import java.awt.Color;
import java.util.Stack;

public class Mercedes extends Truck implements Loadable {
    private final TransportationBed transportationBed;

    public Mercedes(double xPosition, double yPosition) {
        super("Mercedes", 2, 90, Color.cyan, xPosition, yPosition, new OnOffLift());
        transportationBed = new TransportationBed(20);
    }

    public int getLoadSize() {
        return transportationBed.getLoadSize();
    }

    public Stack<Car> getLoadedCars() {
        return transportationBed.getLoadedCars();
    }

    public int getVehicleCount() {
        return transportationBed.getVehicleCount();
    }

    private boolean isCarWithinRange(Car car) {
            
        return car.getXPosition() >= getXPosition() - 5
            && car.getXPosition() <= getXPosition() + 5
            && car.getYPosition() >= getYPosition() - 5
            && car.getXPosition() <= getXPosition() + 5;

    }

    @Override
    public void load(Car car) {
        // Loads a car onto the Mercedes
        if (isRaised()) {
            System.out.println("Can't load while ramp is up");
            return;
        }
        else if (isCarWithinRange(car))
            // Car must be within a 5 m radius of the transport truck to be loaded
            transportationBed.load(car);

    }

    @Override
    public Car unload() {
        // Removes car from truck
        Car car = transportationBed.unload();
        return car;
    }

}
