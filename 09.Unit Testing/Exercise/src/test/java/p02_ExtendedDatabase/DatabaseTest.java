package p02_ExtendedDatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private static final Person PERSON = new Person(1, "Ivan");
    private static final Person PERSON_TWO = new Person(2, "George");
    private static final Person PERSON_THREE = new Person(3, "Martin");

    private static final Person[] PEOPLE = new Person[]{PERSON, PERSON_TWO, PERSON_THREE};

    private Database database;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    void testDatabaseSuccessfullyStoresElements() {
        Person[] dbElements = database.getElements();
        assertArrayEquals(PEOPLE, dbElements);
    }

    @Test
    void testDatabaseThrowsExceptionWhenReceivesMoreThan16Elements() {
        Person[] invalidArrayOfPeople = new Person[17];
        assertThrows(OperationNotSupportedException.class, () -> database = new Database(invalidArrayOfPeople));
    }

    @Test
    void testDatabaseThrowsExceptionWhenReceivesNoElements() {
        Person[] invalidArrayOfPeople = new Person[0];
        assertThrows(OperationNotSupportedException.class, () -> database = new Database(invalidArrayOfPeople));
    }

    @Test
    void testAddThrowsExceptionWhenElementIsNull() {
        assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    void testAdd() throws OperationNotSupportedException {
        Person personToAdd = new Person(4, "Peter");
        database.add(personToAdd);

        Person[] expectedArray = new Person[4];
        System.arraycopy(PEOPLE, 0, expectedArray, 0, PEOPLE.length);
        expectedArray[3] = personToAdd;

        assertArrayEquals(expectedArray, database.getElements());
    }

    @Test
    void testRemoveThrowsExceptionWhenThereAreNoElementsLeft() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        assertThrows(OperationNotSupportedException.class, () -> database.remove());
    }

    @Test
    void testRemove() throws OperationNotSupportedException {
        database.remove();
        assertArrayEquals(new Person[]{PERSON, PERSON_TWO}, database.getElements());
    }

    @Test
    void testFindByUsernameThrowsExceptionWhenUsernameIsNULL() {
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }

    @Test
    void testFindByUsernameThrowsExceptionWhenNoUsersAreFound() {
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Stefan"));
    }

    @Test
    void testFindByUsername() throws OperationNotSupportedException {
        assertEquals(PERSON, database.findByUsername("Ivan"));
        assertEquals(PERSON_TWO, database.findByUsername("George"));
    }

    @Test
    void testFindByIdThrowsExceptionWhenNoUsersAreFound() {
        assertThrows(OperationNotSupportedException.class, () -> database.findById(4));
    }

    @Test
    void testFindById() throws OperationNotSupportedException {
        assertEquals(PERSON, database.findById(1));
        assertEquals(PERSON_TWO, database.findById(2));
    }
}