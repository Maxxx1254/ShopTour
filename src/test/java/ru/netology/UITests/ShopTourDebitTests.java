package ru.netology.UITests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;
import ru.netology.Page.MainPage;
import ru.netology.helpers.UserHelper;

import static com.codeborne.selenide.Selenide.open;

public class ShopTourDebitTests {

    MainPage main;

    @Test
    void shouldAllFieldsEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard("", "", "", "", "");
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
        main.EnterFieldsIfDebitCard("12341234123412", "1", "3", UserHelper.getRandomValidCardholder(), "99");
        main.FieldCardError(0);
        main.FieldCardError(1);
        main.FieldCardError(2);
        main.FieldCardError(3);
    }

    @Test
    void shouldInvalidMonthAndYearBiggest() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getValidCardNumber(), "99", "99", UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.InvalidDate(0);
        main.InvalidDate(1);
    }

    @Test
    void shouldInvalidYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(0), UserHelper.getRandomInvalidYear(1), UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.ExpiredCardError();
    }

    @Test
    void shouldInvalidMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomInvalidMonth(1), UserHelper.getRandomYear(0), UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.InvalidDate(0);
    }

    @Test
    void shouldIncorrectName() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(1), UserHelper.getRandomYear(1), UserHelper.getRandomInvalidCardholderFromNumbers(), UserHelper.getCardCode());
        main.InvalidName();
    }

    @SneakyThrows
    @Test
    void rejection() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getCardNumberDeclined(), UserHelper.getRandomMonth(1), UserHelper.getRandomYear(1), UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.pullRequest(0);
    }

    @SneakyThrows
    @Test
    void shouldIncorrectNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(1), UserHelper.getRandomYear(1), UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.pullRequest(1);
    }

    @SneakyThrows
    @Test
    void approval() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(1), UserHelper.getRandomYear(1), UserHelper.getRandomValidCardholder(), UserHelper.getCardCode());
        main.pullRequest(0);
    }
}
