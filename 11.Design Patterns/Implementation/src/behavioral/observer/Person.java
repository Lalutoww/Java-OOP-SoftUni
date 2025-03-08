package behavioral.observer;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
