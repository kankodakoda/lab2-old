import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(double xpos, double ypos) {
        super("Saab95", 2, 125, Color.red, xpos, ypos);
        turboOn = false;
    }

    public boolean getTurboOn() {
        return turboOn;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
