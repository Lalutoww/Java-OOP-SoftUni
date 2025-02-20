package vehicles;

public class Truck extends Vehicle {
    private static final double SUMMER_CONSUMPTION_INCREASE = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;


    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + SUMMER_CONSUMPTION_INCREASE);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_EFFICIENCY);
    }


}
