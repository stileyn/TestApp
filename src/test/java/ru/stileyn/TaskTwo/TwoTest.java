package ru.stileyn.TaskTwo;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class TwoTest {

    @Test
    void testGenerateRandomArray() {
        Two two = new Two();
        int[] array = two.generateRandomArray(10, 1, 10);
        assertEquals(10, array.length);
        for (int num : array) {
            assertTrue(num >= 1 && num <= 10);
        }
    }

    @Test
    void testFindFrequency() {
        Two two = new Two();
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> frequencyMap = two.findFrequency(array);
        assertEquals(1, frequencyMap.get(1));
        assertEquals(2, frequencyMap.get(2));
        assertEquals(3, frequencyMap.get(3));
        assertNull(frequencyMap.get(4));
    }

    @Test
    void testPrintMostFrequentNumbers() {
        Two two = new Two();
        Map<Integer, Integer> frequencyMap = Map.of(1, 1, 2, 2, 3, 3);
        assertDoesNotThrow(() -> two.printMostFrequentNumbers(frequencyMap));
    }


}
