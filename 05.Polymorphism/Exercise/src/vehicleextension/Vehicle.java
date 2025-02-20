package vehicleextension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private final double litersPerKm;
    private final double tankCapacity;
    private double fuelQuantity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
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
        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.getClass().getSimpleName() + ": " + df.format(fuelQuantity);
    }
}
