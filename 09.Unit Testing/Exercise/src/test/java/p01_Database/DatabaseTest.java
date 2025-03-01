package p01_Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private Database database;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    void testDatabaseSuccessfullyStoresElements() {
        Integer[] dbElements = database.getElements();
        assertArrayEquals(NUMBERS, dbElements);
    }

    @Test
    void testDatabaseThrowsExceptionWhenReceivesMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] invalidNumbers = new Integer[17];
        assertThrows(OperationNotSupportedException.class, () -> database = new Database(invalidNumbers));
    }

    @Test
    void testDatabaseThrowsExceptionWhenReceivesNoElements() throws OperationNotSupportedException {
        Integer[] invalidNumbers = new Integer[0];
        assertThrows(OperationNotSupportedException.class, () -> database = new Database(invalidNumbers));
    }

    @Test
    void testAddThrowsExceptionWhenElementIsNull() {
        assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    void testAdd() throws OperationNotSupportedException {
        database.add(5);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, database.getElements());
    }

    @Test
    void testRemoveThrowsExceptionWhenThereAreNoElementsLeft() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        assertThrows(OperationNotSupportedException.class, () -> database.remove());
    }

    @Test
    void testRemove() throws OperationNotSupportedException {
        database.remove();
        assertArrayEquals(new Integer[]{1,2,3}, database.getElements());
    }
}