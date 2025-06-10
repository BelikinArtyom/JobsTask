package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CustomerDisplayPage extends TestBase {

    private final SelenideElement
            defaultItemName = $(".dk-section-position__item-name"),
            itemDescription = $(".dk-section-position__item-description"),
            itemPrice = $(".dk-section-position__item-price"),
            radioB = $("#radio_1"),
            addToCartButton =  $("[data-analytics-id=BUY-CLENT-CONFIGURATOR-ADD-BASKET-BUTTON]"),
            successPopup = $(".dk-unit-lead");


    public final CustomerDisplayPage openPage() {
        open ("https://dreamkas.ru/");
        sleep(1000);
        open("/periferiya/displey-pokupatelya/kupit/");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(
                new org.openqa.selenium.Cookie("current_city", "0JLQvtC70LPQvtCz0YDQsNC0"));
        return this;
    }

    public CustomerDisplayPage defaultItem () {
        defaultItemName.shouldHave(text("Дисплей покупателя"));
        itemDescription.shouldHave(text("Отображает стандартную информацию и сообщения о промоакциях и скидках. Высота стойки, углы поворота и наклона регулируются. Помещается строки по 20 символов."));
        itemPrice.shouldHave(text("8 000 ₽"));

//        $(".dk-section-position__item-name").shouldHave(text("Дисплей покупателя"));  // default name
//        $(".dk-section-position__item-description").shouldHave(text("Отображает стандартную информацию и сообщения о промоакциях и скидках. Высота стойки, углы поворота и наклона регулируются. Помещается строки по 20 символов."));
//        $(".dk-section-position__item-price").shouldHave(text("8 000 ₽"));
        return this;
    }

    public CustomerDisplayPage selectNewItem () {
        radioB.click();
        return this;
    }

    public CustomerDisplayPage selectedItemInfo () {

        defaultItemName.shouldHave(text("Приложение Дримкас Дисплей"));
        itemDescription.shouldHave(text("Дисплей умеет отображать QR-код для платежей, показывать вес товара, способ оплаты, скидку, количество сдачи и вашу рекламу."));
        itemPrice.shouldHave(text("1 990 ₽"));

//        $(".dk-section-position__item-name").shouldHave(text("Приложение Дримкас Дисплей"));  // default name
//        $(".dk-section-position__item-description").shouldHave(text("Дисплей умеет отображать QR-код для платежей, показывать вес товара, способ оплаты, скидку, количество сдачи и вашу рекламу."));
//        $(".dk-section-position__item-price").shouldHave(text("1 990 ₽"));
        return this;
    }

    public CustomerDisplayPage addToCartItem () {
        addToCartButton.click();
        successPopup.shouldHave(text(" Добавлено в корзину"));

//        $("[data-analytics-id=BUY-CLENT-CONFIGURATOR-ADD-BASKET-BUTTON]").click();
//        $(".dk-unit-lead").shouldHave(text(" Добавлено в корзину"));
        return this;
    }
}
