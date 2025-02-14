package pizzacalories;

public enum DoughModifiers {
    WHITE(1.5), WHOLEGRAIN(1.0), CRISPY(0.9), CHEWY(1.1), HOMEMADE(1.0);

    final double calorieModifier;

    DoughModifiers(double calorieModifier) {
        this.calorieModifier = calorieModifier;
    }

    static public DoughModifiers getStringValue(String doughType) {
        return DoughModifiers.valueOf(doughType.toUpperCase());
    }

    public double getCalorieModifier() {
        return calorieModifier;
    }
}
