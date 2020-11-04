package ru.sergeyzhirkov.homework2;


import ru.sergeyzhirkov.homework2.exceptions.MyArrayDataException;
import ru.sergeyzhirkov.homework2.exceptions.MyArraySizeException;
import ru.sergeyzhirkov.homework2.utilities.ProcessingArray;

import java.util.Random;

public class Main {
    public static final int NUMBER_OF_TESTS = 20;

    public static void main(String[] args) {
        Random random = new Random();
        ProcessingArray processingArray = new ProcessingArray();

        for (int i = 1; i <= NUMBER_OF_TESTS; i++) {
            System.out.println("\nTest #" + i);
            int randomSizeArrayLength = 3 + random.nextInt(3);
            String[][] array = processingArray.preparationArray(randomSizeArrayLength);
            processingArray.showArray(array);
            try {
                processingArray.arrayHandler(array);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println("Некорректные входные данные:" + e.getMessage());
            }
        }
    }

}
