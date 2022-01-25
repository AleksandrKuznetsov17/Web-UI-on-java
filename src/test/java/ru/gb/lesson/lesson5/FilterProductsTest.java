package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterProductsTest extends BaseTest {

    @Test
    void filterPriceTest() {
        webDriver.get("https://pop-music.ru/catalog/gitaryi/akusticheskie-bas-gitary/");
        int fromPrice = Integer.parseInt(webDriver.findElement(By.id("arrFilterElement_P1_MIN")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int toPrice = Integer.parseInt(webDriver.findElement(By.id("arrFilterElement_P1_MAX")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int quarter = (toPrice - fromPrice) / 4;

        List<WebElement> sliders = webDriver.findElements(By.xpath("//div[@role='slider']"));

        int width = sliders.get(0).getSize().width;
        Point pointFrom = sliders.get(0).getLocation();
        Point pointTo = sliders.get(1).getLocation();

        int length = pointTo.getX() - pointFrom.getX() + width;

        Actions actions = new Actions(webDriver);

        actions.dragAndDropBy(sliders.get(0), length / 4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions
                        .attributeToBe(By.id("arrFilterElement_P1_MIN"), "value", String.valueOf(fromPrice + quarter)));

        actions.dragAndDropBy(sliders.get(1), -length / 4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions
                        .attributeToBe(By.id("arrFilterElement_P1_MAX"), "value", String.valueOf(toPrice - quarter)));
    }
}
