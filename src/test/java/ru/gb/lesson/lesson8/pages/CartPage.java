package ru.gb.lesson.lesson8.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    @Step("Проверить, что в корзине только {productNames}")
    public void checkProductsInCart(String... productNames) {
        $$x("//div[contains(@class, 'cart-table__row js-product')]//a[@class='cart-table__name']")
                .shouldHave(CollectionCondition.exactTextsCaseSensitiveInAnyOrder(productNames)
                        .because("Название продукта в корзине должно соответствовать ожидаемому "));
    }
}
