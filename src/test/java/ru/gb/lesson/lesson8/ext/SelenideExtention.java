package ru.gb.lesson.lesson8.ext;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.gb.lesson.lesson8.config.TestConfig;

public class SelenideExtention implements BeforeAllCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Configuration.baseUrl = TestConfig.testConfig.baseUrl();
        Configuration.browser = "chrome";
        SelenideLogger.addListener("Allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
