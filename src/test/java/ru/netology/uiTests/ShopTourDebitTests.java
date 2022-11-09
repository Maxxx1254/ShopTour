package ru.netology.uiTests;

import lombok.SneakyThrows;
import org.testng.annotations.Test;
import ru.netology.helpers.UserHelper;
import ru.netology.page.DebitPage;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ShopTourDebitTests {

    MainPage main;
    DebitPage debit;

    @Test
    void testMainPage() {
        main.elementsComparisonMainPage();
        main.elementsComparisonDebitPage();
    }

    @Test
    void approval() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void rejection() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberDeclined(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldIncorrectNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(1);
    }

    @Test
    void shouldIncorrectNumberWithSpaces() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumberWithSpaces(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(1);
    }

    @Test
    void shouldIncorrectNumberFromFifteen() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberFromFifteen(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldIncorrectNumberFromSeventeen() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberFromSeventeen(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(1);
    }

    @Test
    void shouldCardNumberTwoNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getFromOneNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardNumberTwoLetters() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getFromTwoLetters(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardNumberTwoSymbol() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getTwoSymbols(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardNumberOneNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getFromOneNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardNumberEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getEmptyField(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldInvalidMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomInvalidMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.invalidDate(0);
    }

    @Test
    void shouldBagInFieldMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.invalidDate(0);
    }

    @Test
    void shouldCardMonthTwoSymbol() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getTwoSymbols(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldInvalidBigMonth() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(0);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getNonExistentMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.invalidDate(0);
    }

    @SneakyThrows
    @Test
    void shouldIncorrectMonthFromThreeNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth() + UserHelper.getFromOneNumber(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardMonthOneNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getFromOneNumber(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardMonthOneLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getFromOneLetter(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardMonthEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getEmptyField(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldInvalidYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomInvalidYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.expiredCardError();
    }

    @Test
    void shouldInvalidBigYear() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(6);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.invalidDate(0);
    }

    @Test
    void shouldCardYearOneNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getFromOneNumber(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardYearOneLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getFromOneLetter(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardYearTwoSymbol() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getTwoSymbols(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardYearFromThreeNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear() + UserHelper.getFromOneNumber(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardYearEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getEmptyField(), UserHelper.getRandomValidCardholder(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardholderOneLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getFromOneLetter(), UserHelper.getThreeNumber());
        debit.fieldCardError();
        //Вопрос, с чем мне сравнить выражение "Неверный формат" в поле владелец. По идее если бы этот элемент был, он бы сравнивался как я написал, но его нет и поэтому 3 в списке будет уведомление в поле CVC/CVV
    }

    @Test
    void shouldCardholderFromTwoLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getFromOneLetter(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardholderFromTwentyFiveLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getCardholderFromTwentyFiveLetter(), UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardholderFromWithSpaces() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), "Saltykov-Schedrin Mischael", UserHelper.getThreeNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardholderFromTwentySevenLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getCardholderFromTwentySevenLetter(), UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardholderFromRussianLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), "Иванов Иван", UserHelper.getThreeNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardholderTwoSymbol() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getTwoSymbols(), UserHelper.getThreeNumber());
        debit.fieldCardError();
        //Вопрос, с чем мне сравнить выражение "Неверный формат" в поле владелец. По идее если бы этот элемент был, он бы сравнивался как я написал, но его нет и поэтому 3 в списке будет уведомление в поле CVC/CVV
    }

    @Test
    void shouldCardholderOneNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getFromOneNumber(), UserHelper.getThreeNumber());
        debit.fieldCardError();
        //Вопрос, с чем мне сравнить выражение "Неверный формат" в поле владелец. По идее если бы этот элемент был, он бы сравнивался как я написал, но его нет и поэтому 3 в списке будет уведомление в поле CVC/CVV
    }

    @Test
    void shouldCardholderEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getEmptyField(), UserHelper.getThreeNumber());
        debit.fieldCardholderError();
    }

    @Test
    void shouldCardCodeEmpty() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getEmptyField());
        debit.fieldCardError();
    }

    @Test
    void shouldCardCodeOneNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getFromOneNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardCodeTwoNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getFromTwoNumber());
        debit.fieldCardError();
    }

    @Test
    void shouldCardCodeFourNumber() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getFourNumber());
        debit.pullRequest(0);
    }

    @Test
    void shouldCardCodeTwoSymbol() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getTwoSymbols());
        debit.fieldCardError();
    }

    @Test
    void shouldCardCodeOneLetter() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getCardNumberApproved(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomValidCardholder(), UserHelper.getFromOneLetter());
        debit.fieldCardError();
    }

    @Test
    void shouldIncorrectName() {
        open("http://localhost:8080/");
        main = new MainPage();
        debit = new DebitPage();
        UserHelper.getNumberMonth(1);
        UserHelper.getNumberYear(1);
        debit.enterFieldsIfDebitCard(UserHelper.getValidCardNumber(), UserHelper.getRandomMonth(), UserHelper.getRandomYear(), UserHelper.getRandomInvalidCardholderFromNumbers(), UserHelper.getThreeNumber());
        debit.invalidName();
    }
}
