package pages;

import com.codeborne.selenide.Selenide;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CustomerDisplayPage extends TestBase {

    public final CustomerDisplayPage openPage() {
        open("/periferiya/displey-pokupatelya/kupit/");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(
                new org.openqa.selenium.Cookie("current_city", "0JLQvtC70LPQvtCz0YDQsNC0")
        );
        return this;
    }

    public CustomerDisplayPage defaultItem () {
        $(".dk-section-position__item-name").shouldHave(text("Дисплей покупателя"));  // default name
        $(".dk-section-position__item-description").shouldHave(text("Отображает стандартную информацию и сообщения о промоакциях и скидках. Высота стойки, углы поворота и наклона регулируются. Помещается строки по 20 символов."));
        $(".dk-section-position__item-price").shouldHave(text("8 000 ₽"));
        return this;
    }

    public CustomerDisplayPage selectNewItem () {
        $("#radio_1").click();
        return this;
    }

    public CustomerDisplayPage selectedItemInfo () {
        $(".dk-section-position__item-name").shouldHave(text("Приложение Дримкас Дисплей"));  // default name
        $(".dk-section-position__item-description").shouldHave(text("Дисплей умеет отображать QR-код для платежей, показывать вес товара, способ оплаты, скидку, количество сдачи и вашу рекламу."));
        $(".dk-section-position__item-price").shouldHave(text("1 990 ₽"));
        return this;
    }

    public CustomerDisplayPage addToCartItem () {
        $("[data-analytics-id=BUY-CLENT-CONFIGURATOR-ADD-BASKET-BUTTON]").click();
        $(".dk-unit-lead").shouldHave(text(" Добавлено в корзину"));
        return this;
    }
}
