import java.awt.*;

public abstract class Vehicle implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPosition;
    private double yPosition;
    private double directionAngle;

    public Vehicle(String modelName, int nrDoors, double enginePower, Color color, double xPosition, double yPosition) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        currentSpeed = 0;
        directionAngle = 0;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public double getdirectionAngle() {
        return directionAngle;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public abstract double speedFactor();

    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Ogiltigt värde");
            return; // Stoppar metoden från att fortsätta
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Not valid");
            return;
        }
        decrementSpeed(amount);
    }

    protected void incrementSpeed(double amount) {
        if (getCurrentSpeed() + speedFactor() * amount > enginePower)
            System.out.println("Current speed can't be higher than engine power");
        else
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount) {
        if (getCurrentSpeed() - speedFactor() * amount < 0)
            System.out.println("Current speed can't be lower than 0");
        else
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void move() {
        double movementX;
        double movementY;

        double directionAngleRadians = Math.toRadians(directionAngle);

        movementX = Math.cos(directionAngleRadians) * speedFactor();
        movementY = Math.sin(directionAngleRadians) * speedFactor();

        xPosition += movementX;
        yPosition += movementY;

    }

    @Override
    public void turnLeft(double amount) {

        if (amount > 0) {
            directionAngle = Math.toRadians(directionAngle);
            amount = Math.toRadians(amount);
            directionAngle += amount;
            if (directionAngle >= 2 * Math.PI) {
                directionAngle -= 2 * Math.PI;
            }
            directionAngle = Math.toDegrees(directionAngle);
        }

        else {
            System.out.println("Invalid");
        }
    }

    @Override
    public void turnRight(double amount) {

        if (amount > 0) {
            directionAngle = Math.toRadians(directionAngle);
            amount = Math.toRadians(amount);
            directionAngle -= amount;
            if (directionAngle < 0) {
                directionAngle += 2 * Math.PI;
            }
            directionAngle = Math.toDegrees(directionAngle);

        }
        else
            System.out.println("Invalid");
    }
}
