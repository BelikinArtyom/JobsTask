package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DreamKassPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class DreamKassSolutions extends TestBase {


    @AfterEach
    void Attach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.getVideoUrl();
        Attach.addVideo();
    }

    @Feature("Страница 'Решения'")
    @Story("Блоки на странице 'Решения'")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ссылка в блоках на странице 'Решения' ведет на коректную страницу")
    @Tag("WorkWork")
    @Test
    public void solutionHeadersTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем страницу", () -> {
            dreamKassPage.openPage();
        });

        step("Проверяем, что ссылка баннера ведет на корректную страницу", () -> {
            dreamKassPage.bannerHrefCheck();
        });
    }

    @Feature("Страница 'Решения'")
    @Story("Цены на сервисы на странице 'Решения'")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Цены на сервисы корректно пробрасываются на следующую страницу")
    @Tag("WorkWork")
    @Test
    public void servicePriceTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем страницу", () -> {
            dreamKassPage.openPage();
        });

        step("Проверяем цену соответствие при переходе на карточку Шавермы", () -> {
            dreamKassPage.shawarmaCardPriceCheck();
        });
    }

    @Feature("Страница 'Решения'")
    @Story("Попап для обратной связи по предзаказу")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Модель товара для предзаказа пробрасывается в попап обратной связи")
    @Tag("WorkWork")
    @Test
    public void preOrderCallModelTest () {

        SelenideLogger.addListener("allure", new AllureSelenide());
        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем страницу", () -> {
            dreamKassPage.openPage();
        });

        step("Нажимаем на Предзаказ у товара и проверяем модель в попапе", () -> {
            dreamKassPage.preOrderPopupModel();
        });
    }
}




