package ru.sergeyzhirkov.homework2.exceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super(String.format("\nкоординаты бракованной ячейки (%d, %d)", i + 1, j + 1));
    }
}
