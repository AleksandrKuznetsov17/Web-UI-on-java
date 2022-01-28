package ru.gb.lesson.lesson6.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson6.pages.MainPage;
import ru.gb.lesson.lesson6.pages.blocks.LoginPopup;

import static ru.gb.lesson.lesson6.PrepareTestExtention.webDriver;

@DisplayName("Авторизация pop-music")
public class AuthPopMusicTest extends BaseTest {

    @Test
    @DisplayName("Авторизация: существующий юзер - позитивный")
    void successfulAuthTest() {
        webDriver.get(URL);

        new MainPage(webDriver).getMainHeader()
                .clickLoginButton()
                .login(login, password)
                .getMainHeader()
                .logout()
                .getMainHeader()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация: некорректный пароль - негативный")
    void incorrectPasswordFailedAuthTest() {
        webDriver.get(URL);

        new MainPage(webDriver).getMainHeader()
                .clickLoginButton()
                .login(login, "sdfsdfsdgasedg");
        new LoginPopup(webDriver)
                .checkError("Неверный логин или пароль.");
    }

}
