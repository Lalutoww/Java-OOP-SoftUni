package pizzacalories;

public enum ToppingsModifiers {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    final double toppingModifier;

    ToppingsModifiers(double toppingModifier) {
        this.toppingModifier = toppingModifier;
    }

    public double getToppingModifier() {
        return toppingModifier;
    }

    static public ToppingsModifiers getStringValue(String topping) {
        return ToppingsModifiers.valueOf(topping.toUpperCase());
    }
}
