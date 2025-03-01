package p04_BubbleSortTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleTest {
    private static final int[] NOT_SORTED = new int[]{4, 3, 1, 5, 2};
    private static final int[] SORTED = new int[]{1, 2, 3, 4, 5};
    private static final int[] EMPTY_ARR = new int[0];

    @Test
    void testSortWorksProperly() {
        Bubble.sort(NOT_SORTED);
        assertArrayEquals(SORTED, NOT_SORTED);
    }

    @Test
    void testSortReturnsTheSameArrayIfItIsAlreadySorted() {
        int[] newArr = SORTED.clone();
        Bubble.sort(newArr);
        assertArrayEquals(SORTED, newArr);
    }

    @Test
    void testSortReturnsSameArrayWhenGetsAnEmptyArr() {
        Bubble.sort(EMPTY_ARR);
        assertEquals(0, EMPTY_ARR.length);
    }


}