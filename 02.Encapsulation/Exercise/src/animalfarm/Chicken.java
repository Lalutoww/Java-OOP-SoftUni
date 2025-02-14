package animalfarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age >= 16) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }

    private double calculateProductPerDay() {
        double eggsPerDay;
        if (age < 6) {
            eggsPerDay = 2;
        } else if (age <= 11) {
            eggsPerDay = 1;
        } else {
            eggsPerDay = 0.75;
        }

        return eggsPerDay;
    }
}
