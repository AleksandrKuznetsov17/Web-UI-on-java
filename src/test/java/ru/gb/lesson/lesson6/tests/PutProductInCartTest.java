package ru.gb.lesson.lesson6.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson6.pages.MainPage;

import static ru.gb.lesson.lesson6.PrepareTestExtention.webDriver;

public class PutProductInCartTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Бас-гитара CORT AB590MF-BOP"})
    void putProductInCartTest(String productName) {

        webDriver.get(URL);

        new MainPage(webDriver)
                .getMainHeader()
                .goToProductPage("Гитары", "Акустические бас-гитары")
                .putProductInCart(productName)
                .goToCart()
                .checkProductsInCart(productName);
    }
}
