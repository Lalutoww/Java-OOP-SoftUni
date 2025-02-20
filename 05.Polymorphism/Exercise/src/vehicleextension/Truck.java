package vehicleextension;

public class Truck extends Vehicle {
    private static final double SUMMER_CONSUMPTION_INCREASE = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + SUMMER_CONSUMPTION_INCREASE, tankCapacity);
    }


    @Override
    public void refuel(double liters) {
        double actualFuelAdded = liters * REFUEL_EFFICIENCY;
        if (super.getFuelQuantity() + actualFuelAdded > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(actualFuelAdded);
    }


}
