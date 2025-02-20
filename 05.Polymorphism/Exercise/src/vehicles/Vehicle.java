package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected final double litersPerKm;
    protected double fuelQuantity;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public void drive(double kilometers) {
        double requiredFuel = kilometers * litersPerKm;
        String type = this.getClass().getSimpleName();

        if (requiredFuel <= fuelQuantity) {
            fuelQuantity -= requiredFuel;
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println(type + " traveled " + df.format(kilometers) + " km");
        } else {
            System.out.println(type + " needs refueling");
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.getClass().getSimpleName() + ": " + df.format(fuelQuantity);
    }
}
