package ru.sergeyzhirkov.homework2.exceptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int length) {
        super("\nневерные размеры массива - " + length);
    }
}
