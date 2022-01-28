package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductsInCart(String... productNames) {
        List<String> actualProducts = webDriver.findElements(By.xpath("//div[contains(@class, 'cart-table__row js-product')]"))
                .stream()
                .map(el -> el.findElement(By.xpath(".//a[@class='cart-table__name']")).getText())
                .collect(Collectors.toList());

        assertThat(actualProducts)
                .as("Название продукта в корзине должно соответствовать ожидаемому ")
                .containsExactlyInAnyOrder(productNames);
    }
}
