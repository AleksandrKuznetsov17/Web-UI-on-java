package ru.gb.lesson.lesson8.pages.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson8.pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPopup implements WrapsElement {
    SelenideElement wrapElement;
    private final By userNameInput = By.name("USER_LOGIN");
    private final By passwordInput = By.name("USER_PASSWORD");
    private final By errorSpan = By.xpath("//span[@class='errortext']");
    private final By loginButton = By.xpath("//button[span[text()='Войти']]");

    public LoginPopup() {
        this.wrapElement = $(By.xpath("//form[contains(@name,'system_auth')]"));
    }

    @Step("Авторизоваться под учеткой {login} {password}")
    public MainPage login(String login, String password) {
        By authFormLocator = By.xpath("//form[contains(@name,'system_auth')]");
        $(authFormLocator).shouldBe(Condition.visible);
        $(userNameInput).sendKeys(login);
        $(passwordInput).sendKeys(password);
        $(loginButton).click();
        return new MainPage();
    }

    @Step("Проверить, что отображается ошибка {0}")
    public void checkError(String errorText) {
        $(errorSpan).shouldBe(Condition.have(Condition.exactText(errorText)));
    }

    @Override
    public WebElement getWrappedElement() {
        return wrapElement;
    }
}
