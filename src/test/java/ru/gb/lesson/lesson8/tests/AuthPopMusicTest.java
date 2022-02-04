package ru.gb.lesson.lesson8.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson8.config.TestConfig;
import ru.gb.lesson.lesson8.ext.SelenideExtention;
import ru.gb.lesson.lesson8.pages.MainPage;
import ru.gb.lesson.lesson8.pages.blocks.LoginPopup;

import static com.codeborne.selenide.Selenide.page;

@DisplayName("Авторизация pop-music")
@ExtendWith({SelenideExtention.class})
public class AuthPopMusicTest {

    @Test
    @DisplayName("Авторизация: существующий юзер - позитивный")
    @Severity(SeverityLevel.BLOCKER)
    void successfulAuthTest() {
        Selenide.open(Configuration.baseUrl);

        page(MainPage.class).getMainHeader()
                .clickLoginButton()
                .login(TestConfig.testConfig.login(), TestConfig.testConfig.password())
                .getMainHeader()
                .logout()
                .getMainHeader()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация: некорректный пароль - негативный")
    @Severity(SeverityLevel.NORMAL)
    void incorrectPasswordFailedAuthTest() {
        Selenide.open(Configuration.baseUrl);

        page(MainPage.class).getMainHeader()
                .clickLoginButton()
                .login(TestConfig.testConfig.login(), "sdfsdfsdgasedg");
        page(LoginPopup.class)
                .checkError("Неверный логин или пароль.");
    }

}
