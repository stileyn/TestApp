package ru.stileyn.TaskOne;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class OneTest {

    @Test
    public void testReorderArray() {
        int[] array = {1, 7, 0, 4, 6, 3, 0, 9, 2};
        int[] expected = {1, 7, 3, 9, 0, 0, 4, 6, 2};

        One.reorderArray(array);

        assertArrayEquals(expected, array);
    }
}