package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DisplayName("Авторизация pop-music")
public class AuthPopMusicTest extends BaseTest {


    @Test
    @DisplayName("Авторизация: существующий юзер - позитивный")
    void successfulAuthTest() {


        webDriver.get("https://pop-music.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Войти")).click();
        By authFormLocator = By.xpath("//form[contains(@name,'system_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("12345678");
        authForm.findElement(By.xpath("//button[span[text()='Войти']]")).click();

        webDriver.findElement(By.cssSelector("div.header__user")).click();
        webDriver.findElement(By.linkText("Выйти")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));
    }


    @Test
    @DisplayName("Авторизация: некорректный пароль - негативный")
    void incorrectPasswordFailedAuthTest() {

        webDriver.get("https://pop-music.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Войти")).click();
        By authFormLocator = By.xpath("//form[contains(@name,'system_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("invalid_password");
        authForm.findElement(By.xpath("//button[span[text()='Войти']]")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Неверный логин или пароль.']")));
    }

}
