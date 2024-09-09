package org.example.Errors;

public class MyPowException extends RuntimeException {
    public MyPowException(int row, int col, int value) {
        super("Полный квадрат или куб в ячейке [" + row + "][" + col + "]: " + value);
        printStackTrace();
    }
}
