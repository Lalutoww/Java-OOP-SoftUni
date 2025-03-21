package carshopextended;

public class Seat extends CarImpl implements Sellable {
    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s sells for %f", super.toString(), getModel(), price);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
