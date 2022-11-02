package ru.netology.helpers;

import com.github.javafaker.Faker;

public class UserHelper {
    private static final Faker faker = new Faker();

    public static String getInvalidCardNumber() {return faker.numerify("################");}

    public static String getCardNumberApproved() {return "1111 2222 3333 4444";}

    public static String getCardNumberDeclined() {return "5555 6666 7777 8888";}

    public static String getRandomCardholder() {return faker.name().username();}

    public static String getCardCode() {return faker.numerify("###");}
}