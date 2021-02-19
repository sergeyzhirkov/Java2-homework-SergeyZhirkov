package ru.sergeyzhirkov.homework3.task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "111-11-11");
        phoneBook.add("Petrov", "222-22-22");
        phoneBook.add("Sidorov", "333-33-33");
        phoneBook.add("Ivanov", "444-44-44");
        phoneBook.add("Ivanov", "555-55-55");
        phoneBook.add("kollektors", "8-800-555-35-35");
        phoneBook.add("downloads", "4242");

        phoneBook.get("Petrov");
        phoneBook.get("Ivanov");
        phoneBook.get("kollektors");
        phoneBook.get("Вася");
    }
}
