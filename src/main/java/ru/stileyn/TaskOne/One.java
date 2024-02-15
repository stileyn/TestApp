package ru.stileyn.TaskOne;

import java.util.Random;

public class One {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        fillArray(array);

        System.out.println("Исходный массив:");
        printArray(array);

        reorderArray(array);

        System.out.println("Переупорядоченный массив:");
        printArray(array);
    }

    private static void fillArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        // Гарантированный случай, что в массиве есть хотя бы один ноль
        array[random.nextInt(array.length)] = 0;
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void reorderArray(int[] array) {
        int[] tempArray = new int[array.length];
        int oddIndex = 0;
        int evenIndex = array.length - 1;

        // Помещение нечетных чисел в начало временного массива
        for (int num : array) {
            if (num % 2 != 0) {
                tempArray[oddIndex++] = num;
            }
        }

        // Помещение нулей в середину временного массива
        for (int num : array) {
            if (num == 0) {
                tempArray[oddIndex++] = num;
            }
        }

        // Помещение четных чисел в конец временного массива
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && array[i] != 0) {
                tempArray[evenIndex--] = array[i];
            }
        }

        // Копирование элементов из временного массива в исходный
        System.arraycopy(tempArray, 0, array, 0, array.length);
    }
}
