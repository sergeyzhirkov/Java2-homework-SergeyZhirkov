package ru.sergeyzhirkov.homework3.task2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new TreeMap<>();

    public void add(String lastName, String phoneNumber) {
        Set<String> setPhone = phoneBook.getOrDefault(lastName, new HashSet<>());
        phoneBook.putIfAbsent(lastName, setPhone);
        setPhone.add(phoneNumber);
    }

    public void get(String lastName) {
        System.out.printf("\nFor lastName %s found:\n", lastName);
        phoneBook.getOrDefault(lastName, Set.of("--- nothing numbers!")).forEach(e -> System.out.println("number: " + e));
    }
}
