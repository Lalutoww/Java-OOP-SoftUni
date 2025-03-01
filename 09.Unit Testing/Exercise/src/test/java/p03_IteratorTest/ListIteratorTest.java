package p03_IteratorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {
    public static final List<String> LIST_OF_NAMES = Arrays.asList("Stefan", "Ivan", "Petar");

    ListIterator listIterator;
    ListIterator emptyListIterator;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(LIST_OF_NAMES.toArray(new String[0]));
        emptyListIterator = new ListIterator();
    }

    @Test
    void testConstructorWithNullPaException() {
        assertThrows(OperationNotSupportedException.class, () -> listIterator = new ListIterator(null));
    }

    @Test
    void testListIsCreatedProperly() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    void testHasNextIfListHasElements() {
        assertTrue(listIterator.hasNext());
    }

    @Test
    void testHasNextIfListHasOneElement() throws OperationNotSupportedException {
        listIterator = new ListIterator(new String[]{"Ivan"});
        assertFalse(listIterator.hasNext());
    }

    @Test
    void testHasNextIfListIsEmpty() {
        assertFalse(emptyListIterator.hasNext());

    }

    @Test
    void testPrintWhenListIsEmptyMustFails() {
        assertThrows(IllegalStateException.class, () -> emptyListIterator.print());
    }

    @Test
    void testPrintWhenArrayHasMoreParameters() throws OperationNotSupportedException {
        for (String currentName : LIST_OF_NAMES) {
            assertEquals(listIterator.print(), currentName);
            if (listIterator.hasNext()) {
                listIterator.move();
            }
        }
    }
}