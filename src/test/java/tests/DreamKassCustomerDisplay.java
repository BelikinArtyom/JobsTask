package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CustomerDisplayPage;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class DreamKassCustomerDisplay extends TestBase {


    @AfterEach
    void Attach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.getVideoUrl();
        Attach.addVideo();
    }


    @Feature("Оборудование")
    @Story("Дисплей покупателя")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Описание товара соответствует выбранному товару")
    @Tag("WorkWork")
    @Test
    public void displayToggleTest () {

        SelenideLogger.addListener("allure", new AllureSelenide());
        CustomerDisplayPage customerDisplayPage = new CustomerDisplayPage();


        step("Открываем страницу с дефолтным товаром", () -> {
            customerDisplayPage.openPage();
        });

        step("Проверяем текст дефолтного товара", () -> {
            customerDisplayPage.defaultItem();
        });

        step("Выбираем новый товар через радиобаттон", () -> {
            customerDisplayPage.selectNewItem();
        });

        step("Проверяем текст выбранного товара", () -> {
            customerDisplayPage.selectedItemInfo();
        });

        System.out.println("Cookies after setting: " +
                Selenide.webdriver().driver().getWebDriver().manage().getCookies());
    }


    @Feature("Оборудование")
    @Story("Добавление товара в корзину")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Выбранный товар добавлен в корзину")
    @Tag("WorkWork")
    @Test
    public void addToCartItemTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        CustomerDisplayPage customerDisplayPage = new CustomerDisplayPage();

        step("Открываем страницу с дефолтным товаром", () -> {
            customerDisplayPage.openPage();
        });

        step("Выбираем новый товар через радиобаттон", () -> {
            customerDisplayPage.selectNewItem();
        });

        step("Выбираем новый товар через радиобаттон", () -> {
            customerDisplayPage.addToCartItem();
        });

        System.out.println("Cookies after setting: " +
                Selenide.webdriver().driver().getWebDriver().manage().getCookies());
    }
}
