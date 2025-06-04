package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DreamKassPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
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
    public void preOrderCallModel () {

        DreamKassPage dreamKassPage = new DreamKassPage();

        step("Открываем форму", () -> {
            dreamKassPage.openPage();
        });

        step("Нажимаем на Предзаказ у товара и проверяем модель в попапе", () -> {
            dreamKassPage.preOrderPopupModel();
        });
    }
}




