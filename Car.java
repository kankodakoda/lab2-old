import java.awt.Color;

public abstract class Car extends Vehicle {
    
    public Car(String modelName, int nrDoors, double enginePower, Color color, double xPosition, double yPosition) {
        super(modelName, nrDoors, enginePower, color, xPosition, yPosition);
    }
}
