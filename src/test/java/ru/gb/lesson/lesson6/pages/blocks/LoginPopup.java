package ru.gb.lesson.lesson6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson6.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPopup implements WrapsElement {
    WebDriver webDriver;
    WebElement wrapElement;
    private By userNameInput = By.name("USER_LOGIN");
    private By passwordInput = By.name("USER_PASSWORD");
    private By errorSpan = By.xpath("//span[@class='errortext']");
    private By loginButton = By.xpath("//button[span[text()='Войти']]");

    public LoginPopup(WebDriver webDriver) {
        this.wrapElement = webDriver.findElement(By.xpath("//form[contains(@name,'system_auth')]"));
        this.webDriver = webDriver;
    }

    public MainPage login(String login, String password) {
        By authFormLocator = By.xpath("//form[contains(@name,'system_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        webDriver.findElement(userNameInput).sendKeys(login);
        webDriver.findElement(passwordInput).sendKeys(password);
        webDriver.findElement(loginButton).click();
        return new MainPage(webDriver);
    }

    public void checkError(String errorText) {
        assertThat(webDriver.findElement(errorSpan).getText())
                .isEqualTo(errorText);
    }

    @Override
    public WebElement getWrappedElement() {
        return wrapElement;
    }
}
