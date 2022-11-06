package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitPage {
    private final SelenideElement mainPage = $("[class=App_appContainer__3jRx1]");
    private final SelenideElement tabPurchaseOnDebit = $(withText("Оплата по карте"));
    private final ElementsCollection purchaseOnDebitCard = $$(withText("Купить"));
    private final SelenideElement fieldCardNumber = $("[maxlength='19']");
    private final SelenideElement fieldCardMonth = $("[placeholder='08']");
    private final SelenideElement fieldCardYear = $("[placeholder='22']");
    private final ElementsCollection fieldsCard = $$("[class='input__control']");
    private final SelenideElement fieldCardCode = $("[maxlength='3']");
    private final SelenideElement buttonContinue = $(withText("Продолжить"));
    private final SelenideElement fieldError = $(withText("Неверный формат"));
    private final ElementsCollection incorrectDate = $$(withText("Неверно указан срок действия карты"));
    private final SelenideElement fieldsCardholderError = $(withText("Поле обязательно для заполнения"));
    private final SelenideElement invalidName = $(withText("Некорректное имя"));
    private final SelenideElement buttonRequest = $(withText("Отправляем запрос в Банк..."));
    private final ElementsCollection notification = $$("[class='notification__icon']");
    private final SelenideElement expiredError = $(withText("Истёк срок действия карты"));

    public void enterFieldsIfDebitCard(String number, String month, String year, String cardholder, String code) {
        purchaseOnDebitCard.first().click();
        tabPurchaseOnDebit.should(visible);
        fieldCardNumber.setValue(number);
        fieldCardMonth.setValue(month);
        fieldCardYear.setValue(year);
        mainPage.scrollIntoView(false);
        fieldsCard.get(3).setValue(cardholder);
        fieldCardCode.setValue(code);
        buttonContinue.click();
    }

    public void fieldCardError() {
        fieldError.should(visible);
    }

    public void fieldCardholderError() {
        fieldsCardholderError.should(visible);
    }

    public void invalidDate(int number) {
        incorrectDate.get(number).should(visible);
    }

    public void invalidName() {
        invalidName.should(visible);
    }

    public void pullRequest(int number) {
        buttonRequest.should(visible);
        mainPage.scrollIntoView(true);
        notification.get(number).shouldBe(visible, Duration.ofSeconds(15));
    }

    public void expiredCardError() {
        expiredError.should(visible);
    }
}
