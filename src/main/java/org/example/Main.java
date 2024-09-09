package org.example;

import org.example.Errors.MyArrayDataException;
import org.example.Errors.MyArraySizeException;
import org.example.Errors.MyCentralException;
import org.example.Errors.MyPowException;

public class Main {
    public static void main(String[] args) {
        // Пример 4x4 массива
        String[][] array = {
                {"0", "2", "4", "4"},
                {"5", "7", "7", "8"},
                {"9", "11", "11", "12"},
                {"13", "14", "14", "16"}
        };

        try {
            int sum = processArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException | MyCentralException | MyPowException e) {
            // Исключения уже обработаны и их стек трейс напечатан в классе исключения
        }
    }

    public static int processArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException(array.length, array.length > 0 ? array[0].length : 0);
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException(array.length, row.length);
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);

                    // Проверка на центральные многоугольные числа
                    if (isCentralPolygonNumber(value)) {
                        throw new MyCentralException(i, j, value);
                    }

                    // Проверка на полные квадраты или кубы (шестизначные)
                    if (isPerfectSquareOrCube(value)) {
                        throw new MyPowException(i, j, value);
                    }

                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }

        return sum;
    }

    private static boolean isCentralPolygonNumber(int number) {
        // Проверяем, является ли число центральным многоугольным числом
        int n = 1;
        while (n * (n + 1) / 2 < number) {
            n++;
        }
        return n * (n + 1) / 2 == number;
    }

    private static boolean isPerfectSquareOrCube(int number) {
        if (number < 100000 || number > 999999) {
            return false;
        }

        // Проверка на полный квадрат
        int sqrt = (int) Math.sqrt(number);
        if (sqrt * sqrt == number) {
            return true;
        }

        // Проверка на полный куб
        int cbrt = (int) Math.cbrt(number);
        if (cbrt * cbrt * cbrt == number) {
            return true;
        }

        return false;
    }
}