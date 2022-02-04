package ru.gb.lesson.lesson8.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage extends BasePage {

    @Step("Добавить товар {productName} в корзину")
    public ProductsPage putProductInCart(String productName) {
        $x("//div[contains(@class, 'product-card ') and contains(., '" + productName + "')]")
                .$x(".//div[contains(@class,'product-card__btn')]").shouldNotHave(Condition.exactText("Ожидается")).click();
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        $x("//*[contains(text(),'Перейти в корзину')]")
                .shouldBe(Condition.visible.because("Должен появиться алерт с кнопкой 'Перейти в корзину'"), Duration.ofSeconds(4))
                .click();
        return new CartPage();
    }
}
