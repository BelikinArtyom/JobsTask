package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.UUID;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.browserSize = System.getProperty("browser.size", "2560x1440");

        Configuration.baseUrl = "https://dreamkas.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub",
                System.getProperty("selenoid_login", "user1"),
                System.getProperty("selenoid_password", "1234"),
                System.getProperty("selenoid_host", "selenoid.autotests.cloud"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "Test: " + UUID.randomUUID()
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
