package ru.sergeyzhirkov.homework2.utilities;

import ru.sergeyzhirkov.homework2.exceptions.MyArrayDataException;
import ru.sergeyzhirkov.homework2.exceptions.MyArraySizeException;

import java.util.Random;

public class ProcessingArray {

    public static final int ARRAY_SIZE_DEFAULT = 4;

    public void arrayHandler(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != ARRAY_SIZE_DEFAULT) {
            throw new MyArraySizeException(array.length);
        } else {
            for (String[] strings : array) {
                if (strings.length != ARRAY_SIZE_DEFAULT) {
                    throw new MyArraySizeException(strings.length);
                }
            }
        }
        SumElementsArray(array);
    }

    private void SumElementsArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }


    public String[][] preparationArray(int size) {
        if ((size != ARRAY_SIZE_DEFAULT) || (Math.random() > 0.7)) {
            return preparationArrayOfInt(size);
        } else {
            return preparationArrayBroken(size);
        }
    }

    private String[][] preparationArrayOfInt(int size) {
        String[][] array = new String[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = Integer.toString(random.nextInt(9));
            }
        }
        return array;
    }

    private String[][] preparationArrayBroken(int size) {
        Random random = new Random();
        String[][] array = preparationArrayOfInt(size);
        array[random.nextInt(size)][random.nextInt(size)] = "A";
        return array;
    }

    public void showArray(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }
    }

}
