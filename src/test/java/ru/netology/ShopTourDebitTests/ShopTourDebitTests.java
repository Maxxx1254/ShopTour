package ru.netology.ShopTourDebitTests;

import org.testng.annotations.Test;
import ru.netology.Page.MainPage;

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
    void shouldInvalidMonthAndYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        main.EnterFieldsIfDebitCard("1234123412341234", "15", "30", "Varlamov", "999");
        main.FieldCardError(0);
        main.FieldCardError(1);
        main.FieldCardError(2);
        main.FieldCardholderError();
        main.FieldCardError(3);
    }
}
