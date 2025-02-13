package salaryincrease;

import java.text.DecimalFormat;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0##");
        return String.format("%s %s gets %s years old.", firstName, lastName, df.format(salary));
    }

    public void increaseSalary(double increase) {
        if (age < 30) {
            increase /= 2;
        }
        salary *= 1 + increase / 100;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
