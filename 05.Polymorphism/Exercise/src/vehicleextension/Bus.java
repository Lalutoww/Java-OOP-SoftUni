package vehicleextension;

public class Bus extends Vehicle {
    private final static double CONSUMPTION_INCREASE_WITH_PEOPLE = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + CONSUMPTION_INCREASE_WITH_PEOPLE, tankCapacity);
    }

    public void driveEmpty(double kilometers) {
        super.drive(kilometers * CONSUMPTION_INCREASE_WITH_PEOPLE);
    }
}
