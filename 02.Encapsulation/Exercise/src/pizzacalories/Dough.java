package pizzacalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private static void checkIfDoughIsValid(String bakingTechnique) {
        try {
            DoughModifiers.getStringValue(bakingTechnique);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setFlourType(String flourType) {
        checkIfDoughIsValid(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        checkIfDoughIsValid(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeCalories = DoughModifiers.getStringValue(flourType).getCalorieModifier();
        double bakingTechniqueCalories = DoughModifiers.getStringValue(bakingTechnique).getCalorieModifier();
        return flourTypeCalories * bakingTechniqueCalories * weight * 2;
    }
}
