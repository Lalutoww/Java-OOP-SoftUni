package creational.builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .setName("John Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .build();

        System.out.println(person);
    }
}
