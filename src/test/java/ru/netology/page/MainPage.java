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

    public void elementsComparison() {
        mainPage.should(visible);
        header.should(visible);
        image.should(visible);
        country.last().should(visible);
        condition1.should(visible);
        condition2.should(visible);
        condition3.should(visible);
        condition4.should(visible);
        purchaseOnCredit.should(visible);
        purchaseOnDebitCard.first().should(visible);
        purchaseOnCredit.click();
        tabPurchaseOnCredit.should(visible);
        purchaseOnDebitCard.first().click();
        tabPurchaseOnDebit.should(visible);
    }
}
