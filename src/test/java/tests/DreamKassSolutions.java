package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DreamKassPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class DreamKassSolutions extends TestBase {

    @Feature("Страница 'Решения'")
    @Story("Блоки на странице 'Решения'")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ссылка в блоках на странице 'Решения' ведет на коректную страницу")
    @Tag("WorkWork")
    @Test
    public void solutionHeadersTest() {

        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем форму", () -> {
            dreamKassPage.openPage();
        });

        step("Открываем форму", () -> {
            dreamKassPage.bannerHrefCheck();
        });
    }
}


