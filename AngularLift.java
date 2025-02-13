class AngularLift implements RampAbility {
    private double rampAngle;
    private boolean isRaised;

    public AngularLift() {
        rampAngle = 0;
        isRaised = false;
    }

    @Override
    public boolean isRaised() {
        return isRaised;
    }

    public double getRampAngle() {
        return rampAngle;
    }

    public void raiseRamp(double amount) {
        // Raise ramp by amount degrees
        if (amount <= 0)
            return;
        if (amount + rampAngle > 70.0) {
            System.out.println("Ramp can't be raised anymore");
            rampAngle = 70.0;
        }
        else
            rampAngle += amount;
            if (rampAngle == 70.0)
                isRaised = true;

    }
    
    public void lowerRamp(double amount) {
        // Lower ramp by amount degrees
        if (amount <= 0)
            return;
        if (rampAngle - amount < 0){
            System.out.println("Ramp can't be lowered anymore");
            rampAngle = 0;
        }
        else
            rampAngle -= amount;
            if (rampAngle != 70)
                isRaised = false;
    }

    @Override
    public void raiseRamp() {
        // Fully raises ramp to 70 degrees
        rampAngle = 70;
    }

    @Override
    public void lowerRamp() {
        // Fully lowers ramp to 0 degrees
        rampAngle = 0;
    }

}
