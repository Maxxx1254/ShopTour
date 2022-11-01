package ru.netology.ShopTourDebitTests;

import org.testng.annotations.Test;
import ru.netology.Page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ShopTourCreditTests {
    MainPage main;

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
    void shouldInvalidIncorrectData() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("12341234123412", "1", "3", "Varlamov", "99");
        main.FieldCardError(0);
        main.FieldCardError(1);
        main.FieldCardError(2);
        main.FieldCardholderError();
        main.FieldCardError(3);
    }

    @Test
    void shouldInvalidMonthAndYearBiggest() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("1234123412341234", "99", "99", "Varlamov", "999");
        main.InvalidDate(0);
        main.InvalidDate(1);
    }

    @Test
    void shouldInvalidMonthAndYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("1234123412341234", "10", "21", "Varlamov", "999");
        main.InvalidDate(0);
        main.InvalidDate(1);
    }

    @Test
    void shouldInvalidMonthAndMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("1234123412341234", "10", "22", "Varlamov", "999");
        main.InvalidDate(0);
        main.InvalidDate(1);
    }

    @Test
    void shouldIncorrectName() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("1234123412341234", "12", "23", "1231231", "999");
        main.InvalidName();
    }

    @Test
    void rejection() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("5555 6666 7777 8888", "12", "23", "Varlamov", "999");
        main.pullRequest(1);
    }

    @Test
    void approval() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfCreditCard("1111 2222 3333 4444", "12", "23", "Varlamov", "999");
        main.pullRequest(0);
    }
}
