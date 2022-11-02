package ru.netology.Tests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;
import ru.netology.Page.MainPage;
import ru.netology.helpers.UserHelper;

import static com.codeborne.selenide.Selenide.open;

public class ShopTourCreditTests {
    MainPage main;
    UserHelper user;

    @Test
    void shouldAllFieldsEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("", "", "", "", "");
        main.FieldCardError(0);
        main.FieldCardError(1);
        main.FieldCardError(2);
        main.FieldCardholderError();
        main.FieldCardError(3);
    }

    @Test
    void shouldInvalidIncorrectDataNumberCode() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("12341234123412", "1", "3", UserHelper.getRandomCardholder(), "99");
        main.FieldCardError(0);
        main.FieldCardError(1);
        main.FieldCardError(2);
        main.FieldCardError(3);
    }

    @Test
    void shouldInvalidMonthAndYearBiggest() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getInvalidCardNumber(), "99", "99", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.InvalidDate(0);
        main.InvalidDate(1);
    }

    @Test
    void shouldInvalidYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getInvalidCardNumber(), "10", "21", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.ExpiredCardError();
    }

    @Test
    void shouldInvalidMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getInvalidCardNumber(), "10", "22", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.InvalidDate(0);
    }

    @Test
    void shouldIncorrectName() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getInvalidCardNumber(), "12", "23", "12312!@#", UserHelper.getCardCode());
        main.InvalidName();
    }

    @SneakyThrows
    @Test
    void rejection() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getCardNumberDeclined(), "12", "23", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.pullRequest(0);
    }

    @SneakyThrows
    @Test
    void shouldIncorrectNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getInvalidCardNumber(), "12", "23", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.pullRequest(1);
    }

    @SneakyThrows
    @Test
    void approval() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard(UserHelper.getCardNumberApproved(), "12", "23", UserHelper.getRandomCardholder(), UserHelper.getCardCode());
        main.pullRequest(0);
    }
}
