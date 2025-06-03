package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DreamKassPage;
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

    @Feature("Страница 'Решения'")
    @Story("Цены на сервисы на странице 'Решения'")
    @Owner("belikinA")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Цены на сервисы корректно пробрасываются на следующую страницу")
    @Tag("WorkWork")
    @Test
    public void servicePriceTest() {

        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем форму", () -> {
            dreamKassPage.openPage();
        });

        step("Проверяем ссылки в Сервисах", () -> {
            dreamKassPage.servicesCards();
        });


    }
}




