package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

import tests.TestBase;


public class DreamKassPage extends TestBase {

    public DreamKassPage openPage() {
        open("/oborudovanie");
        return this;
    }

    public DreamKassPage bannerHrefCheck() {
        $$(".catalog-banners a").get(0)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-tabaka/"));

        $$(".catalog-banners a").get(1)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/markirovka-tovarov/markirovka-obuvi/"));

        $$(".catalog-banners a").get(2)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/uslugi/"));

        $$(".catalog-banners a").get(3)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/dreamkas-start-atol/"));

        return this;
    }

    public DreamKassPage servicesCards () {
        $$(".dk-section-goods__item-link").get(2)
                .shouldBe(visible)
                .shouldHave(attribute("href",baseUrl +  "/kassy-viki/dreamkas-start-shawarma/kupit/#?kit=%7B%22287%22%3A700%7D")).click();
        $(".dk-section-customer-order__total-title").sibling(0).shouldHave(text("9 900 ₽"));


        return this;
    }

}
