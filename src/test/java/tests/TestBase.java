package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = System.getProperty("browser.size", "2560x1440");
        Configuration.baseUrl = "https://dreamkas.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = false;
    }
}