package ru.sergeyzhirkov.homework5;

import java.util.Arrays;

public class Concurrency {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    float[] arr1 = new float[SIZE];
    float[] arr2 = new float[SIZE];
    {
        Arrays.fill(arr1,1);
        Arrays.fill(arr2,1);
    }

    public static void main(String[] args) {
        Concurrency concurrency = new Concurrency();
        concurrency.oneThreadingCalculate();
        concurrency.twoThreadingCalculate();
    }

    private void oneThreadingCalculate() {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(String.format("First process finish - %d milliseconds", timeEnd - timeStart));
    }

    private void twoThreadingCalculate() {
        long timeStart = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr2, 0, a1, 0, HALF);
        System.arraycopy(arr2, HALF, a2, 0, HALF);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("wtf with this thread?");
        }
        System.arraycopy(a1, 0, arr2, 0, HALF);
        System.arraycopy(a2, 0, arr2, HALF, HALF);

        long timeEnd = System.currentTimeMillis();
        System.out.println(String.format("Second process finish - %d milliseconds", timeEnd - timeStart));
    }



}
