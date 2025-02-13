import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

public class CarTest {

    private Car saabCar;
    private Car volvoCar;
    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;
    private Mercedes mercedes;
    private Workshop<Saab95> saabWorkshop;
    private Workshop<Volvo240> volvWorkshop;

    @Before
    public void setUp() {
        saabCar = new Saab95(50, 50);
        volvoCar = new Volvo240(20, 20);
        saab = new Saab95(50, 50);
        volvo = new Volvo240(20, 20);
        scania = new Scania(50, 50);
        mercedes = new Mercedes(20, 20);
        saabWorkshop = new Workshop<Saab95>(10);
        volvWorkshop = new Workshop<Volvo240>(5);

    }

    @Test
    public void checkAttributes() {
        assertEquals("Saab95", saabCar.getModelName());
        assertEquals(2, saabCar.getNrDoors());
        assertEquals(125.0, saabCar.getEnginePower(), 0.001);
        assertEquals(Color.red, saabCar.getColor());
        assertEquals("Volvo240", volvoCar.getModelName());
        assertEquals(4, volvoCar.getNrDoors());
        assertEquals(100.0, volvoCar.getEnginePower(), 0.001);
        assertEquals(Color.black, volvoCar.getColor());

        assertEquals("Scania", scania.getModelName());
        assertEquals(2, scania.getNrDoors(), 0.001);
        assertEquals(90.0, scania.getEnginePower(), 0.001);
        assertEquals(Color.magenta, scania.getColor());
        assertEquals("Mercedes", mercedes.getModelName());
        assertEquals(2, mercedes.getNrDoors());
        assertEquals(90.0, mercedes.getEnginePower(), 0.001);
        assertEquals(Color.cyan, mercedes.getColor());

    }

    // Test getters
    @Test
    public void testGetters() {
        assertEquals(4, volvoCar.getNrDoors());
        assertEquals(100, volvoCar.getEnginePower(), 0.001);
        assertEquals(0, volvoCar.getCurrentSpeed(), 0.001);
        assertEquals(Color.black, volvoCar.getColor());
        assertEquals("Volvo240", volvoCar.getModelName());
        assertEquals(90, volvoCar.getdirectionAngle(), 0.001);
        assertEquals(20, volvoCar.getXPosition(), 0.001);
        assertEquals(20, volvoCar.getYPosition(), 0.001);

    }

    // Volvo tests
    @Test
    public void checkVolvoTrimFactor() {
        assertEquals(1.25, Volvo240.trimFactor, 0.001);
    }

    @Test
    public void testVolvoGas() {
        double previousSpeed = volvo.getCurrentSpeed();
        volvo.gas(1);
        System.out.println(volvo.getCurrentSpeed());
        assertTrue(volvo.getCurrentSpeed() > previousSpeed);

        previousSpeed = volvo.getCurrentSpeed();
        volvo.gas(-1);
        assertTrue(volvo.getCurrentSpeed() == previousSpeed);

    }

    @Test
    public void testVolvoBrake() {
        volvo.gas(1);
        double previousSpeed = volvo.getCurrentSpeed();
        volvo.brake(1);
        assertTrue(volvo.getCurrentSpeed() < previousSpeed);

        previousSpeed = volvo.getCurrentSpeed();
        volvo.brake(-1);
        assertTrue(volvo.getCurrentSpeed() == previousSpeed);
    }

    // Saab tests
    @Test
    public void testTurboOn() {
        Saab95 saab2 = new Saab95(20, 20);
        saab2.setTurboOn();
        assertTrue(saab2.getTurboOn());
    }

    @Test
    public void testTurboOff() {
        Saab95 saab2 = new Saab95(20, 20);
        saab2.setTurboOff();
        assertFalse(saab2.getTurboOn());
    }

    @Test
    public void testSaabGas() {
        double previousSpeed = saabCar.getCurrentSpeed();
        saabCar.gas(1);
        assertTrue(saabCar.getCurrentSpeed() > previousSpeed);
    }

    @Test
    public void testSaabBrake() {
        saab.gas(1);
        double previousSpeed = saab.getCurrentSpeed();
        saab.brake(1);
        assertTrue(saab.getCurrentSpeed() < previousSpeed);
    }

    @Test
    public void testSpeedFactor() {
        saab.gas(1);
        saab.setTurboOn();
        assertEquals(1.6, saab.speedFactor(), 0.1);
    }

    // Car tests
    @Test
    public void testSetColor() {
        volvo.setColor(Color.yellow);
        assertEquals(Color.yellow, volvo.getColor());
    }

    @Test
    public void testMovement() {
        saab.turnLeft(10);

        saab.move();
        assertNotEquals(50, saab.getXPosition(), 0.001);
        assertNotEquals(50, saab.getYPosition(), 0.001);
    }

    @Test
    public void testTurnRight() {
        volvo.turnRight(10);
        assertEquals(80, volvo.getdirectionAngle(), 0.001);

        double previousAngle = volvo.getdirectionAngle();
        volvo.turnRight(360);
        assertEquals(previousAngle, volvo.getdirectionAngle(), 0.001);
    }

    @Test
    public void testTurnRightInvalidInput() {
        double previousAngle = volvo.getdirectionAngle();
        System.out.println(volvo.getdirectionAngle());
        volvo.turnRight(-10);
        System.out.println(volvo.getdirectionAngle());
        assertEquals(previousAngle, volvo.getdirectionAngle(), 0.001);
    }

    @Test
    public void testTurnLeft() {
        volvo.turnLeft(10);
        assertEquals(100, volvo.getdirectionAngle(), 0.001);

        double previousAngle = volvo.getdirectionAngle();
        volvo.turnLeft(360);
        assertEquals(previousAngle, volvo.getdirectionAngle(), 0.001);
    }

    @Test
    public void testTurnLeftInvalidInput() {
        double previousAngle = volvo.getdirectionAngle();
        volvo.turnLeft(-10);
        assertEquals(previousAngle, volvo.getdirectionAngle(), 0.001);
    }

    @Test
    public void testMove() {
        double previousXPos = volvo.getXPosition();
        double previousYPos = volvo.getYPosition();

        volvo.turnRight(10);
        volvo.move();

        assertTrue(volvo.getXPosition() > previousXPos);
        assertTrue(volvo.getYPosition() > previousYPos);
    }

    @Test
    public void testStartEngine() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testStopEngine() {
        volvo.gas(1);
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testIncrementSpeedValidEntry() {
        double previousSpeed = volvoCar.getCurrentSpeed();
        volvoCar.incrementSpeed(150);
        assertEquals(previousSpeed, volvoCar.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testDecrementSpeedValidEntry() {
        double previousSpeed = volvoCar.getCurrentSpeed();
        volvoCar.decrementSpeed(150);
        assertEquals(previousSpeed, volvoCar.getCurrentSpeed(), 0.001);
    }

    // Scania tests

    @Test
    public void testScaniaGas() {
        scania.gas(1);
        double previousSpeed = scania.getCurrentSpeed();
        scania.gas(1);
        System.out.println(previousSpeed + " | " + scania.getCurrentSpeed());
        assertTrue(scania.getCurrentSpeed() > previousSpeed);
    }

    @Test
    public void testScaniaGasWithRamp() {
        scania.raiseRamp(40);
        scania.gas(0.3);
        assertEquals(0.0, scania.getCurrentSpeed(), 0.001);
    }

    // Mercedes tests

    @Test
    public void testOnOffLift() {
        mercedes.raiseRamp();
        assertTrue(true);
    }

    @Test
    public void testtruckSpeedFactor() {
        mercedes.gas(1);
        System.out.println(mercedes.speedFactor());
        assertEquals(0.9, mercedes.speedFactor(), 0.1);
    }

    @Test
    public void testScaniaRampLimits() {
        scania.raiseRamp(80.0);
        assertEquals(70, scania.getRampAngle(), 0.001);

        scania.lowerRamp(-10);
        assertEquals(70.0, scania.getRampAngle(), 0.001);
    }

    @Test
    public void testScaniaRampWhileMoving() {
        scania.gas(0.5);
        scania.raiseRamp(10);
        System.out.println(scania);
        assertEquals(0, scania.getRampAngle(), 0.001);
    }

    @Test
    public void testScaniaCantMoveWhileRaiseRamp() {
        scania.raiseRamp(70);
        scania.gas(0.5);
        assertEquals(0, scania.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testCarTransportLoad() {
        mercedes.load(new Saab95(mercedes.getXPosition() + 3, mercedes.getYPosition() - 3));
        mercedes.load(new Volvo240(mercedes.getXPosition() + 2, mercedes.getYPosition() - 5));
        assertEquals(2, mercedes.getVehicleCount());
    }

    @Test
    public void testCarTransportUnload() {
        mercedes.load(saab);
        mercedes.load(volvo);
        mercedes.unload();
        mercedes.unload();
        assertEquals(0, mercedes.getVehicleCount());
    }

    @Test
    public void testSaabWorkshop() {
        saabWorkshop.addVehicle(saab);
        saabWorkshop.addVehicle(new Saab95(30, 30));
        saabWorkshop.addVehicle(new Saab95(40, 40));
        assertEquals(3, saabWorkshop.getVehicles().size());

    }

    @Test
    public void testVolvoWorkshop() {
        
        volvWorkshop.addVehicle(volvo);
        assertEquals(1, volvWorkshop.getVehicles().size());

    }

    

}
