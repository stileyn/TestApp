package ru.stileyn.TaskTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Two {
    public static void main(String[] args) {
        int[] array = generateRandomArray(20, 1, 10);

        System.out.println("Исходный массив:");
        printArray(array);

        // Подсчет частоты встречаемости каждого числа в массиве
        Map<Integer, Integer> frequencyMap = findFrequency(array);

        // Вывод наиболее часто встречающихся чисел на экран
        printMostFrequentNumbers(frequencyMap);
    }

    // Метод для генерации случайного массива чисел
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод для подсчета частоты встречаемости каждого числа в массиве
    public static Map<Integer, Integer> findFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    // Метод для вывода наиболее часто встречающихся чисел и их частоты встречаемости на экран
    public static void printMostFrequentNumbers(Map<Integer, Integer> frequencyMap) {
        // Нахождение максимальной частоты встречаемости
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Вывод наиболее часто встречающихся чисел и их частоты встречаемости
        System.out.println("Наиболее часто встречающиеся числа и их частота встречаемости:");
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == maxFrequency) {
                System.out.println("Число " + num + " встречается " + maxFrequency + " раз(а)");
            }
        }
    }
}
