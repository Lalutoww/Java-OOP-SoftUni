package validationdata;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private static void validateName(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    public void increaseSalary(double increase) {
        if (age < 30) {
            increase /= 2;
        }
        salary *= 1 + increase / 100;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last");
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0##");
        return String.format("%s %s gets %s years old.", firstName, lastName, df.format(salary));
    }
}
