package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Корзина: добавление товаров")
public class AddProductToCartTest extends BasicTest {

    @ParameterizedTest(name = "Корзина: успешное добавление товаров")
    @DisplayName("Корзина: успешное добавление товаров")
    @ValueSource(strings = {"Бас-гитара CORT AB590MF-BOP", "БАС-ГИТАРА ARIA-295 N"})
    void successfulAddingProductToCartTest(String productName) {
        webDriver.get(URL);

        webDriver.manage().window().setSize(new Dimension(1920, 1380));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']/li/a[text()='Гитары']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//li[contains(@class, 'is-hover')]//a[text()='Акустические бас-гитары']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[contains(@class, 'product-card ')]"));

        products.stream()
                .filter(product -> product.getText().contains(productName))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Нет товара на странице с названием " + productName))
                .findElement(By.xpath(".//div[contains(@class,'product-card__btn')]"))
                .click();

        new WebDriverWait(webDriver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Перейти в корзину')]")))
                .click();

        List<WebElement> cartProduct = webDriver.findElements(By.xpath("//div[contains(@class, 'cart-table__row js-product')]"));
        assertThat(cartProduct).hasSize(1);
        assertThat(cartProduct.get(0).findElement(By.xpath(".//a[@class='cart-table__name']")).getText())
                .isEqualTo(productName);
    }


}
