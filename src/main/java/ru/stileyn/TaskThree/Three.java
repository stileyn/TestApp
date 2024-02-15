package ru.stileyn.TaskThree;

import java.util.Random;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите последовательность чисел для игрока 1 (через пробел):");
        int[] firstSequence = readSequence(scanner);

        System.out.println("Введите последовательность чисел для игрока 2 (через пробел):");
        int[] secondSequence = readSequence(scanner);

        System.out.println("Введите количество бросков кубика:");
        int dieRoll = scanner.nextInt();

        scanner.close();

        // Моделирование игр для обоих игроков
        int firstWins = simulateGame(firstSequence, secondSequence, dieRoll);
        int secondWins = simulateGame(secondSequence, firstSequence, dieRoll);
        int draws = dieRoll - firstWins - secondWins;

        // Вычисление вероятностей
        double firstOdds = (double) firstWins / dieRoll;
        double secondOdds = (double) secondWins / dieRoll;
        double drawOdds = (double) draws / dieRoll;

        // Вывод результатов
        System.out.println("Вероятность победы первого игрока: " + firstOdds);
        System.out.println("Вероятность победы второго игрока: " + secondOdds);
        System.out.println("Вероятность ничьей: " + drawOdds);
    }

    // Метод для чтения последовательности чисел с клавиатуры
    public static int[] readSequence(Scanner scanner) {
        String input = scanner.nextLine();
        String[] cubeNumber = input.split(" ");
        int[] sequence = new int[3];

        for (int i = 0; i < 3; i++) {
            sequence[i] = Integer.parseInt(cubeNumber[i]);
        }

        return sequence;
    }

    // Метод для моделирования игры между двумя игроками
    public static int simulateGame(int[] firstSequence, int[] secondSequence, int dieRoll) {
        int wins = 0;
        Random random = new Random();

        for (int i = 0; i < dieRoll; i++) {
            int firstScore = calculateScore(firstSequence, random, 100);
            int secondScore = calculateScore(secondSequence, random, 100);

            if (firstScore > secondScore) {
                wins++;
            }
        }

        return wins;
    }

    // Метод для подсчета количества очков для одного игрока
    public static int calculateScore(int[] sequence, Random random, int dieRoll) {
        int score = 0;

        for (int i = 0; i < dieRoll; i++) {
            int dieResult = random.nextInt(6) + 1;

            for (int j = 0; j < 3; j++) {
                if (dieResult == sequence[j]) {
                    score++;
                }
            }
        }

        return score;
    }
}
