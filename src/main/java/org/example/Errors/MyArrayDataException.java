package org.example.Errors;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int col, String data) {
        super("Ошибка данных в ячейке [" + row + "][" + col + "]: " + data);
        printStackTrace();
    }
}
