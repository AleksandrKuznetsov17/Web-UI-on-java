package ru.gb.lesson.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Добавить товар {productName} в корзину")
    public ProductsPage putProductInCart(String productName) {
        webDriver.findElement(
                        By.xpath("//div[contains(@class, 'product-card ') and contains(., '" + productName + "')]"))
                .findElement(By.xpath(".//div[contains(@class,'product-card__btn')]")).click();
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        new WebDriverWait(webDriver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Перейти в корзину')]")))
                .click();
        return new CartPage(webDriver);
    }
}
