package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginAndLogout {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
        webDriver.quit();
    }
}
