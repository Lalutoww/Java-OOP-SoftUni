package p02_ExtendedDatabase;
//created by J.M.

public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.name;
    }
}