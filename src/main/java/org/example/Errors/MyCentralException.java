package org.example.Errors;

public class MyCentralException extends RuntimeException {
    public MyCentralException(int row, int col, int value) {
        super("Центральное многоугольное число в ячейке [" + row + "][" + col + "]: " + value);
        printStackTrace();
    }
}
