package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
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

        $$(".catalog-banners a").get(3)
                .shouldBe(visible)
                .shouldHave(attribute("href", baseUrl + "/dreamkas-start-atol/"));

        return this;
    }
}
