import java.awt.*;

public class Scania extends Truck {
    private AngularLift angularLift;

    public Scania(double xPosition, double yPosition) {
        super("Scania",
                2,
                90,
                Color.magenta,
                xPosition,
                yPosition,
                new AngularLift());

        this.angularLift = (AngularLift) getRampAbility();
    }

    public double getRampAngle() {
        return angularLift.getRampAngle();
    }

    public void raiseRamp(double amount) {
        // Use AngularLifts raise by amount function
        if (getCurrentSpeed() == 0)
            angularLift.raiseRamp(amount);
        else
            System.out.println("Truck must be standing still to raise ramp");
    }

    public void lowerRamp(double amount) {
        // Use AngularLifts lower by amount function
        angularLift.lowerRamp(amount);
    }

    @Override
    public void gas(double amount) {
        // Gas by amount
        if (amount < 0 || amount > 1) {
            System.out.println("Ogiltigt värde");
            return; // Stoppar metoden från att fortsätta
        } 
        else if (angularLift.getRampAngle() != 0) {
            System.out.println("Can't drive if ramp is raised");
        }
        else
            incrementSpeed(amount);

    }

}