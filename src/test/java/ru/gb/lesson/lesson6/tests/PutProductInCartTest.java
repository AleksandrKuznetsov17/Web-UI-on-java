package ru.gb.lesson.lesson6.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson6.pages.MainPage;

@DisplayName("Добавление в корзину")
public class PutProductInCartTest extends BaseTest {

    @DisplayName("Добавить продукт в корзину")
    @ParameterizedTest(name = "Добавить {0} в корзину")
    @ValueSource(strings = {"Бас-гитара CORT AB590MF-BOP"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("В этом тесте проверяется работа процесса бла бла")
    void putProductInCartTest(String productName) {
        Allure.parameter("Название товара", productName);
        webDriver.get(URL);

        new MainPage(webDriver)
                .getMainHeader()
                .goToProductPage("Гитары", "Акустические бас-гитары")
                .putProductInCart(productName)
                .goToCart()
                .checkProductsInCart(productName);
    }
}
