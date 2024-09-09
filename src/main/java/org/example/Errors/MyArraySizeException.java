package org.example.Errors;

// Определяем исключения
public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int rows, int cols) {
        super("Неверный размер массива: " + rows + "x" + cols);
        printStackTrace();
    }
}
