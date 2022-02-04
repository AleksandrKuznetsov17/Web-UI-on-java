package ru.gb.lesson.lesson8.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson8.config.TestConfig;
import ru.gb.lesson.lesson8.ext.SelenideExtention;
import ru.gb.lesson.lesson8.pages.MainPage;

@DisplayName("Добавление в корзину")
@ExtendWith({SelenideExtention.class})
public class PutProductInCartTest {

    @DisplayName("Добавить продукт в корзину")
    @ParameterizedTest(name = "Добавить {0} в корзину")
    @ValueSource(strings = {"Бас-гитара CORT AB850F BK W_BAG"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("В этом тесте проверяется работа процесса бла бла")
    void putProductInCartTest(String productName) {
        Allure.parameter("Название товара", productName);
        Selenide.open(Configuration.baseUrl);

        new MainPage()
                .getMainHeader()
                .goToProductPage("Гитары", "Акустические бас-гитары")
                .putProductInCart(productName)
                .goToCart()
                .checkProductsInCart(productName);
    }
}
