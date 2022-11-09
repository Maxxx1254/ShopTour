package ru.netology.helpers;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class UserHelper {
    private static int numberYear;
    private static int numberMonth;
    private static final Faker faker = new Faker();

    public static String getValidCardNumberWithSpaces() {
        return faker.numerify("##### ##### #### ####");
    }

    public static String getValidCardNumber() {
        return faker.numerify("################");
    }

    public static String getCardNumberFromFifteen() {
        return faker.numerify("###############");
    }

    public static String getCardNumberFromSeventeen() {
        return faker.numerify("#################");
    }

    public static int getNumberMonth(int numberMonth) {
        return numberMonth;
    }

    public static int getNumberYear(int numberYear) {
        return numberYear;
    }

    public static String getCardNumberApproved() {
        return "\"1111 2222 3333 4444\"";
    }

    public static String getCardNumberDeclined() {
        return "\"5555 6666 7777 8888\"";
    }

    public static String getRandomValidCardholder() {
        return faker.name().fullName().toUpperCase();
    }

    public static String getRandomMonth() {
        return LocalDate.now().plusMonths(numberMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getRandomInvalidMonth() {
        return LocalDate.now().minusMonths(numberMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getRandomYear() {
        return LocalDate.now().plusYears(numberYear).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getRandomInvalidYear() {
        return LocalDate.now().minusYears(numberYear).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getRandomInvalidCardholderFromNumbers() {
        return faker.numerify("######");
    }

    public static String getThreeNumber() {
        return faker.numerify("###");
    }

    public static String getFourNumber() {
        return faker.numerify("####");
    }


    public static String getFromTwoNumber() {
        return faker.numerify("##");
    }

    public static String getFromOneNumber() {
        return faker.numerify("#");
    }

    public static String getNonExistentMonth() {
        int invalidVerifyCode = faker.number().numberBetween(13, 99);
        return String.valueOf(invalidVerifyCode);
    }

    public static String getEmptyField() {
        return " ";
    }

    public static String getTwoSymbols() {
        return "%@";
    }

    public static String getFromTwoLetters() {
        return faker.letterify("??");
    }

    public static String getFromOneLetter() {
        return faker.letterify("?");
    }

    public static String getCardholderFromTwentyFiveLetter() {
        return faker.letterify("?????????????????????????");
    }

    public static String getCardholderFromTwentySevenLetter() {
        return faker.letterify("???????????????????????????");
    }

}