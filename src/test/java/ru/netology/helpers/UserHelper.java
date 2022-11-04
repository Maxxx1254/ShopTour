package ru.netology.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserHelper {
    private static final Faker faker = new Faker();

    public static String getValidCardNumber() {
        return faker.numerify("################");
    }

    public static String getCardNumberApproved() {
        return "1111 2222 3333 4444";
    }

    public static String getCardNumberDeclined() {
        return "5555 6666 7777 8888";
    }

    public static String getRandomValidCardholder() {
        return faker.name().fullName().toUpperCase();
    }

    public static String getRandomMonth(int month) {
        return LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getRandomInvalidMonth(int month) {
        return LocalDate.now().minusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getRandomYear(int year) {
        return LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getRandomInvalidYear(int year) {
        return LocalDate.now().minusYears(year).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getRandomInvalidCardholderFromNumbers() {
        return faker.numerify("######");
    }

    public static String getCardCode() {
        return faker.numerify("###");
    }
}