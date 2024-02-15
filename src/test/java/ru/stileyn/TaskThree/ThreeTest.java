/* Не смог написать рабочие тесты для данного задания
package ru.stileyn.TaskThree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThreeTest {

    @Test
    void testFirstScenario() {
        int[] firstSequence = {4, 2, 4};
        int[] secondSequence = {4, 4, 4};
        int firstPlayerScore = 2;
        int secondPlayerScore = 1;

        int calculatedFirstScore = Three.calculateScore(firstSequence);
        int calculatedSecondScore = Three.calculateScore(secondSequence);

        assertEquals(firstPlayerScore, calculatedFirstScore);
        assertEquals(secondPlayerScore, calculatedSecondScore);
    }

    @Test
    void testSecondScenario() {
        int[] firstSequence = {4, 2, 4};
        int[] secondSequence = {4, 4, 4};
        int firstPlayerScore = 1;
        int secondPlayerScore = 2;

        int calculatedFirstScore = Three.calculateScore(firstSequence);
        int calculatedSecondScore = Three.calculateScore(secondSequence);

        assertEquals(firstPlayerScore, calculatedFirstScore);
        assertEquals(secondPlayerScore, calculatedSecondScore);
    }

    @Test
    void testThirdScenario() {
        int[] firstSequence = {4, 2, 4};
        int[] secondSequence = {2, 4, 2};
        int firstPlayerScore = 3;
        int secondPlayerScore = 2;

        int calculatedFirstScore = Three.calculateScore(firstSequence);
        int calculatedSecondScore = Three.calculateScore(secondSequence);

        assertEquals(firstPlayerScore, calculatedFirstScore);
        assertEquals(secondPlayerScore, calculatedSecondScore);
    }

    @Test
    void testFourthScenario() {
        int[] firstSequence = {1, 2, 3};
        int[] secondSequence = {2, 3, 1};
        int firstPlayerScore = 3;
        int secondPlayerScore = 4;

        int calculatedFirstScore = Three.calculateScore(firstSequence);
        int calculatedSecondScore = Three.calculateScore(secondSequence);

        assertEquals(firstPlayerScore, calculatedFirstScore);
        assertEquals(secondPlayerScore, calculatedSecondScore);
    }

    @Test
    void testFifthScenario() {
        int[] firstSequence = {1, 2, 3};
        int[] secondSequence = {4, 5, 5};
        int firstPlayerScore = 0;
        int secondPlayerScore = 1;

        int calculatedFirstScore = Three.calculateScore(firstSequence);
        int calculatedSecondScore = Three.calculateScore(secondSequence);

        assertEquals(firstPlayerScore, calculatedFirstScore);
        assertEquals(secondPlayerScore, calculatedSecondScore);
    }
}
*/