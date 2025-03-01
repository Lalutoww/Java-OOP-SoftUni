package p05_CustomLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {
    private static final Integer TEST_INTEGER_ONE = 10;
    private static final Integer TEST_INTEGER_TWO = 20;
    private static final Integer TEST_INTEGER_THREE = 30;
    private static final Integer TEST_INTEGER_FOUR = 40;

    private CustomLinkedList<Integer> list;
    private CustomLinkedList<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        list = new CustomLinkedList<>();
        list.add(TEST_INTEGER_ONE);
        list.add(TEST_INTEGER_TWO);
        list.add(TEST_INTEGER_THREE);
        emptyList = new CustomLinkedList<>();

    }

    @Test
    void testConstructorShouldSetCorrectValue() {
        assertFalse(emptyList.contains(null));
    }

    @Test
    void testAddDataShouldAddCorrectData() {
        assertEquals(TEST_INTEGER_THREE, list.get(2));
        assertEquals(TEST_INTEGER_TWO, list.get(1));
        assertEquals(TEST_INTEGER_ONE, list.get(0));
    }

    @Test
    void testGetThrowsExceptionWhenIndexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> emptyList.get(0));
    }

    @Test
    void testRemoveDataFromSpecifiedIndexMustReturnCorrectData() {
        assertEquals(TEST_INTEGER_TWO, list.removeAt(1));
    }

    @Test
    void testRemoveDataFromSpecifiedIndexThrowsExceptionWhenIndexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> list.removeAt(4));
    }

    @Test
    void testRemoveDataIfExistReturnIndexOfRemovedData() {
        assertEquals(0, list.remove(TEST_INTEGER_ONE));
    }

    @Test
    void testRemoveIfDataDoesntExistReturnNegativeIndex() {
        assertEquals(-1, list.remove(TEST_INTEGER_FOUR));
    }

    @Test
    void testRemoveAllDataThrowsExceptionWhenListIsEmpty() {
        list.removeAt(0);
        list.removeAt(0);
        list.removeAt(0);
        assertThrows(IllegalArgumentException.class, () -> list.removeAt(0));
    }

    @Test
    void testIndexOfMustReturnCorrectIndexOfGivenObject() {
        assertEquals(2, list.indexOf(TEST_INTEGER_THREE));
        assertEquals(0, list.indexOf(TEST_INTEGER_ONE));
    }

    @Test
    void testSetMustSetCorrectValueAtTheGivenIndex() {
        list.set(0, TEST_INTEGER_FOUR);
        assertEquals(TEST_INTEGER_FOUR, list.get(0));
    }

    @Test
    void testSetMustThrowExceptionIfTheGivenIndexIsOutOfBoundsOrTheListIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> list.set(4, TEST_INTEGER_FOUR));
        assertThrows(IllegalArgumentException.class, () -> emptyList.set(0, TEST_INTEGER_FOUR));
    }
}