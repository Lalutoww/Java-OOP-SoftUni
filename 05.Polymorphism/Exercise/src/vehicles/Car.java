package vehicles;

public class Car extends Vehicle {
    private static final double SUMMER_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + SUMMER_CONSUMPTION_INCREASE);
    }
}
