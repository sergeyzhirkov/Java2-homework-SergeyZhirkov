package ru.sergeyzhirkov.homework3.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String[] array = {
                "slovo", "slovo",
                "slovo1",
                "slovo2", "slovo2",
                "slovo3",
                "slovo4", "slovo4", "slovo4",
                "slovo5",
                "slovo6",
                "slovo7", "slovo7"
        };
        Map<String, Integer> dictionary = new TreeMap<>();
        for (String s : array) {
            dictionary.putIfAbsent(s, 0);
            dictionary.put(s, dictionary.get(s) + 1);
        }

        System.out.println("All words:");
        System.out.println(dictionary.keySet());

        System.out.println("Frequency words:");
        dictionary.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
