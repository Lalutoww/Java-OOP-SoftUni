package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private final double litersPerKm;
    private double fuelQuantity;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public void drive(double kilometers) {
        double requiredFuel = kilometers * litersPerKm;

        String type = this.getClass().getSimpleName();

        if (requiredFuel <= this.fuelQuantity) {
            this.fuelQuantity -= requiredFuel;
            DecimalFormat df = new DecimalFormat("0.##");
            System.out.println(type + " travelled " + df.format(kilometers) + " km");
        } else {
            System.out.println(type + " needs refueling");
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
