package vehicleextension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private final static double CONSUMPTION_INCREASE_WITH_PEOPLE = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + CONSUMPTION_INCREASE_WITH_PEOPLE, tankCapacity);
    }

    public void driveEmpty(double kilometers) {
        double requiredFuel = kilometers * (litersPerKm - CONSUMPTION_INCREASE_WITH_PEOPLE);
        String type = this.getClass().getSimpleName();

        if (requiredFuel <= super.getFuelQuantity()) {
            this.fuelQuantity -= requiredFuel;
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println(type + " traveled " + df.format(kilometers) + " km");
        } else {
            System.out.println(type + " needs refueling");
        }
    }
}
