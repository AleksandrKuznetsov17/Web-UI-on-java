package ru.gb.lesson.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PutProductInCartTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Бас-гитара CORT AB590MF-BOP", "АКУСТИЧЕСКАЯ БАС-ГИТАРА ARIA-295 BK"})
    void putProductInCartTest(String productName) {

        webDriver.get("https://pop-music.ru/");

        webDriver.manage().window().setSize(new Dimension(3000, 3000));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']/li/a[text()='Гитары']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//li[contains(@class, 'is-hover')]//a[text()='Акустические бас-гитары']")).click();

        webDriver.findElement(
                By.xpath("//div[contains(@class, 'product-card ') and contains(., '" + productName + "')]"))
                .findElement(By.xpath(".//div[contains(@class,'product-card__btn')]")).click();

        new WebDriverWait(webDriver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Перейти в корзину')]")))
                .click();

        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//div[contains(@class, 'cart-table__row js-product')]"));

        assertThat(productsInCart).hasSize(1);
        assertThat(productsInCart.get(0).findElement(By.xpath(".//a[@class='cart-table__name']")).getText())
                .as("Название продукта в корзине должно быть " + productName)
                .isEqualTo(productName);
    }
}
