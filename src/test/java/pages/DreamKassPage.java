package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;


public class DreamKassPage extends TestBase {

    private final SelenideElement
            orderTotal = $(".dk-section-customer-order__total-title"),
            tooltipText =  $(".dk-unit-feedback__inner");
    private final ElementsCollection
            catalogBannersLinks = $$(".catalog-banners a"),
            itemLink = $$(".dk-section-goods__item-link"),
            button = $$(".md-button"),
            itemHeader = $$(".dk-section-goods__item h3");


    public DreamKassPage openPage() {
        open("/oborudovanie");
        Selenide.webdriver().driver().getWebDriver().manage().addCookie(
                new org.openqa.selenium.Cookie("current_city", "0JLQvtC70LPQvtCz0YDQsNC0")
        );
        return this;
    }

    public DreamKassPage bannerHrefCheck() {

        catalogBannersLinks.get(0)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-tabaka/"));

        catalogBannersLinks.get(1)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-obuvi/"));

        catalogBannersLinks.get(2)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/uslugi/"));

        catalogBannersLinks.get(3)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/dreamkas-start-atol/"));


//        $$(".catalog-banners a").get(0)
//                .shouldBe(visible)
//                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-tabaka/"));
//
//        $$(".catalog-banners a").get(1)
//                .shouldBe(visible)
//                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-obuvi/"));
//
//        $$(".catalog-banners a").get(2)
//                .shouldBe(visible)
//                .shouldHave(attribute("href", baseUrl + "/uslugi/"));
//
//        $$(".catalog-banners a").get(3)
//                .shouldBe(visible)
//                .shouldHave(attribute("href", baseUrl + "/dreamkas-start-atol/"));
        return this;
    }

    public DreamKassPage shawarmaCardPriceCheck() {

        itemLink.get(2)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/kassy-viki/dreamkas-start-shawarma/kupit/#?kit=%7B%22287%22%3A700%7D")).click();
        $(".dk-section-customer-order__total-title").sibling(0).shouldHave(text("9 900 ₽"));
        orderTotal.sibling(0).shouldHave(text("9 900 ₽"));

//        $$(".dk-section-goods__item-link").get(2)
//                .shouldBe(visible)
//                .shouldHave(attribute("href", baseUrl + "/kassy-viki/dreamkas-start-shawarma/kupit/#?kit=%7B%22287%22%3A700%7D")).click();
//        $(".dk-section-customer-order__total-title").sibling(0).shouldHave(text("9 900 ₽"));
        return this;
    }

    public DreamKassPage preOrderPopupModel() {

        itemHeader.get(1).shouldHave(text("Онлайн-касса Viki Mini")).$(".md-ink-ripple").is(clickable);
        button.findBy(Condition.text("Предзаказ"))
                .shouldBe(Condition.visible)
                .click();
        tooltipText.shouldHave(text("Для заказа Онлайн-касса Viki Mini"));

//        $$(".dk-section-goods__item h3").get(1).shouldHave(text("Онлайн-касса Viki Mini")).$(".md-ink-ripple").is(clickable);
//        $$(".md-button").findBy(Condition.text("Предзаказ"))
//                .shouldBe(Condition.visible)
//                .click();
//        $(".dk-unit-feedback__inner").shouldHave(text("Для заказа Онлайн-касса Viki Mini"));
        return this;
    }
}