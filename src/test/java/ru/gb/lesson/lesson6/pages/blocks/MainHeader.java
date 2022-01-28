package ru.gb.lesson.lesson6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson6.pages.BaseView;
import ru.gb.lesson.lesson6.pages.MainPage;
import ru.gb.lesson.lesson6.pages.ProductsPage;

public class MainHeader extends BaseView {

    @FindBy(linkText = "Войти")
    private WebElement loginButton;

    @FindBy(linkText = "Выйти")
    private WebElement logoutButton;

    @FindBy(css = "div.header__user")
    private WebElement profileButton;

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage goToProductPage(String tab1, String tab2) {
        new Actions(webDriver)
                .click(webDriver.findElement(By.xpath("//ul[@data-type='header']/li/a[text()='" + tab1 + "']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath(String.format("//li[contains(@class, 'is-hover')]//a[text()='%s']", tab2))).click();
        return new ProductsPage(webDriver);
    }

    public LoginPopup clickLoginButton() {
        loginButton.click();
        return new LoginPopup(webDriver);
    }

    public MainPage logout() {
        profileButton.click();
        logoutButton.click();
        return new MainPage(webDriver);
    }

    public MainPage checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));
        return new MainPage(webDriver);
    }

}
