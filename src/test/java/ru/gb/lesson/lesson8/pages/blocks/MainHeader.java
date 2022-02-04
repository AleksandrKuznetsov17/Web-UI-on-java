package ru.gb.lesson.lesson8.pages.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson8.pages.MainPage;
import ru.gb.lesson.lesson8.pages.ProductsPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainHeader {

    private SelenideElement loginButton = $(By.linkText("Войти"));

    private SelenideElement logoutButton = $(By.linkText("Выйти"));

    private SelenideElement profileButton = $(By.cssSelector("div.header__user"));

    @Step("Перейти на страницу {tab1} -> {tab2}")
    public ProductsPage goToProductPage(String tab1, String tab2) {
        $(By.xpath("//ul[@data-type='header']/li/a[text()='" + tab1 + "']")).hover();

        $(By.xpath(String.format("//li[contains(@class, 'is-hover')]//a[text()='%s']", tab2))).click();
        return new ProductsPage();
    }

    @Step("Кликнуть на кнопку Логин")
    public LoginPopup clickLoginButton() {
        loginButton.click();
        return new LoginPopup();
    }

    @Step("Выйти из системы")
    public MainPage logout() {
        profileButton.click();
        logoutButton.click();
        return page(MainPage.class);
    }

    @Step("Проверить, что кнопка Логин отображается на странице")
    public MainPage checkLoginButtonIsVisible() {
        $(By.linkText("Войти")).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return page(MainPage.class);
    }

}
