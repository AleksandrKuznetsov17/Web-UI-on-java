package ru.gb.lesson.lesson8;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.lesson.lesson8.config.TestConfig;
import ru.gb.lesson.lesson8.pages.CartPage;
import ru.gb.lesson.lesson8.pages.ProductsPage;
import ru.gb.lesson.lesson8.pages.blocks.MainHeader;

import static com.codeborne.selenide.Selenide.page;

public class MyStepdefs {
    @Given("Products page is loaded")
    public void productsPageIsLoaded() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10;
        Selenide.open(TestConfig.testConfig.baseUrl());
    }

    @When("User go to {string} -> {string}")
    public void userGoTo(String arg0, String arg1) {
        new MainHeader().goToProductPage(arg0, arg1);
    }

    @And("User select {string}")
    public void userSelect(String arg0) {
        page(ProductsPage.class).putProductInCart(arg0);
    }

    @And("User go to the cart")
    public void userGoToTheCart() {
        page(ProductsPage.class).goToCart();
    }

    @Then("Cart contains {string}")
    public void cartContains(String arg0) {
        page(CartPage.class).checkProductsInCart(arg0);
    }
}
