package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement mainPage = $("[class=App_appContainer__3jRx1]");
    private final SelenideElement header = $(withText("Путешествие дня"));
    private final SelenideElement image = $("[class='Order_cardImage__Q69ii']");
    private final SelenideElement condition1 = $(withText("Сказочный Восток"));
    private final SelenideElement condition2 = $(withText("33 360 миль на карту"));
    private final SelenideElement condition3 = $(withText("До 7% на остаток по счёту"));
    private final SelenideElement condition4 = $(withText("Всего 45 000 руб.!"));
    private final ElementsCollection country = $$(withText("Марракэш"));
    private final SelenideElement purchaseOnCredit = $(withText("Купить в кредит"));
    private final ElementsCollection purchaseOnDebitCard = $$(withText("Купить"));
    private final SelenideElement tabPurchaseOnCredit = $(withText("Кредит по данным карты"));
    private final SelenideElement tabPurchaseOnDebit = $(withText("Оплата по карте"));
    private final ElementsCollection fields = $$("[class='input__control']");
    private final SelenideElement continueButton = $(withText("Продолжить"));

    public void elementsComparisonMainPage() {
        mainPage.should(visible);
        header.should(visible);
        image.should(visible);
        country.last().should(visible);
        condition1.should(visible);
        condition2.should(visible);
        condition3.should(visible);
        condition4.should(visible);
        elementsComparisonDebitPage();
        elementsComparisonCreditPage();
    }

    public DebitPage elementsComparisonDebitPage() {
        purchaseOnDebitCard.first().click();
        purchaseOnDebitCard.first().should(visible);
        tabPurchaseOnDebit.should(visible);
        fields.get(0).should(visible);
        fields.get(1).should(visible);
        fields.get(2).should(visible);
        fields.get(3).should(visible);
        fields.get(4).should(visible);
        continueButton.should(visible);
        return new DebitPage();
    }

    public CreditPage elementsComparisonCreditPage() {
        purchaseOnCredit.should(visible);
        purchaseOnCredit.click();
        tabPurchaseOnCredit.should(visible);
        fields.get(0).should(visible);
        fields.get(1).should(visible);
        fields.get(2).should(visible);
        fields.get(3).should(visible);
        fields.get(4).should(visible);
        continueButton.should(visible);
        return new CreditPage();
    }
}
