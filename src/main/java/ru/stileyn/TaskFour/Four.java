package ru.stileyn.TaskFour;

import java.util.ArrayList;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы списка через пробел: ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        ArrayList<Integer> initialList = new ArrayList<>();
        for (String strNum : inputArray) {
            initialList.add(Integer.parseInt(strNum));
        }

        System.out.println("Введите значение k: ");
        int k = scanner.nextInt();

        System.out.println(findPath(initialList, k)); // Вызываем метод findPath и выводим результат
    }

    // Метод для нахождения последовательностей чисел, сумма которых равна k
    public static String findPath(ArrayList<Integer> list, int k) {
        StringBuilder result = new StringBuilder(); // Создаем объект StringBuilder для формирования результата

        // Находим последовательность чисел, сумма которых равна k
        ArrayList<Integer> correctSeq = discoverSequenceFromSum(k, sumList(list));

        // Если такая последовательность не найдена, возвращаем "Невозможно"
        if (correctSeq == null) {
            return "Невозможно";
        }

        // Перебираем найденные последовательности чисел
        for (Integer num : correctSeq) {
            // Находим пары чисел в списке, сумма которых равна текущему числу из последовательности
            ArrayList<Integer> resultPair = findNumbersInList(list, num);
            // Если пара чисел не найдена, возвращаем "Невозможно"
            if (resultPair == null) {
                return "Невозможно";
            }
            // Формируем строку с результатом
            result.append("Сумма ").append(num).append(" - [");
            for (Integer res : resultPair) {
                result.append("(").append(res).append(")");
            }
            result.append("]  ");

            // Удаляем использованные числа из списка
            removeUsedNumbersFromList(list, resultPair);
        }
        // Возвращаем результат
        return result.toString();
    }

    // Метод для поиска чисел в списке, сумма которых равна num
    public static ArrayList<Integer> findNumbersInList(ArrayList<Integer> list, int num) {
        int searchValue = 0; // Переменная для хранения текущей суммы чисел
        ArrayList<Integer> result = new ArrayList<>(); // Создаем список для хранения найденных чисел

        // Перебираем числа в списке
        for (Integer integer : list) {
            // Если находим число, равное num, добавляем его в результат и возвращаем список
            if (integer == num) {
                result.add(integer);
                return result;
            }
        }

        // Перебираем числа в списке для поиска пар чисел, сумма которых равна num
        for (int k = 0; k < list.size(); k++) {
            for (int i = k; i < list.size(); i++) {
                searchValue += list.get(i); // Увеличиваем текущую сумму на очередное число
                result.add(list.get(i)); // Добавляем число в результат
                // Перебираем оставшиеся числа для поиска пары, сумма которой равна num
                for (int j = i + 1; j < list.size(); j++) {
                    // Если находим пару чисел, сумма которых равна num, добавляем их в результат и возвращаем список
                    if (searchValue + list.get(j) == num) {
                        result.add(list.get(j));
                        return result;
                    }
                }
            }
            searchValue = 0; // Обнуляем текущую сумму
            result.clear(); // Очищаем результат
        }
        // Если пара чисел не найдена, возвращаем null
        return null;
    }

    // Метод для вычисления суммы всех элементов списка
    private static int sumList(ArrayList<Integer> list) {
        int sum = 0; // Переменная для хранения суммы
        // Перебираем числа в списке и добавляем их к сумме
        for (Integer num : list) {
            sum += num;
        }
        // Возвращаем сумму
        return sum;
    }

    // Метод для поиска последовательности чисел, сумма которых равна resultSum и содержит k чисел подряд
    public static ArrayList<Integer> discoverSequenceFromSum(int k, int resultSum) {
        int sum = 0; // Переменная для хранения суммы
        int index = 0; // Индекс для определения начала последовательности
        ArrayList<Integer> list = new ArrayList<>(); // Создаем список для хранения последовательности
        // Пока сумма не превысит resultSum
        while (sum <= resultSum) {
            list.clear(); // Очищаем список
            sum = 0; // Обнуляем сумму
            index++; // Увеличиваем индекс
            // Добавляем числа от index до index + k в список и вычисляем их сумму
            for (int i = index; i < k + index; i++) {
                sum += i;
                list.add(i);
            }
            // Если сумма равна resultSum, возвращаем список
            if (sum == resultSum) {
                return list;
            }
        }
        // Если последовательность не найдена, возвращаем null
        return null;
    }

    // Метод для удаления использованных чисел из списка
    private static void removeUsedNumbersFromList(ArrayList<Integer> initialList, ArrayList<Integer> usedNum) {
        for (int i = 0; i < initialList.size(); i++) {
            for (int j = 0; j < usedNum.size(); j++) {
                if (initialList.get(i).equals(usedNum.get(j))) {
                    initialList.remove(i);
                    usedNum.remove(j);
                    i -= 1;
                    break;
                }
            }
        }
    }
}
