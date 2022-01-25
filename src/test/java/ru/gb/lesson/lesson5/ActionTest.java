package ru.gb.lesson.lesson5;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ActionTest extends BaseTest {

    @Test
    void dragAndDropTest() {
        webDriver.get("https://demoqa.com/sortable");

        List<WebElement> elements = webDriver.findElement(By.id("demo-tabpane-list"))
                .findElements(By.xpath(".//div[contains(@class,'list-group-item')]"));

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elements.get(0).getText()).isEqualTo("One");
        softAssertions.assertThat(elements.get(1).getText()).isEqualTo("Two");
        softAssertions.assertThat(elements.get(2).getText()).isEqualTo("Three");
        softAssertions.assertThat(elements.get(3).getText()).isEqualTo("Four");
        softAssertions.assertThat(elements.get(4).getText()).isEqualTo("Five");
        softAssertions.assertThat(elements.get(5).getText()).isEqualTo("Six");

        softAssertions.assertAll();

        Actions actions = new Actions(webDriver);

        actions.moveToElement(elements.get(0))
                .clickAndHold()
                .pause(Duration.ofSeconds(1))
                .moveToElement(elements.get(5))
                .release()
                .build()
                .perform();

        softAssertions.assertThat(elements.get(0).getText()).isEqualTo("Two");
        softAssertions.assertThat(elements.get(1).getText()).isEqualTo("Three");
        softAssertions.assertThat(elements.get(2).getText()).isEqualTo("Four");
        softAssertions.assertThat(elements.get(3).getText()).isEqualTo("Five");
        softAssertions.assertThat(elements.get(4).getText()).isEqualTo("Six");
        softAssertions.assertThat(elements.get(5).getText()).isEqualTo("One");

        softAssertions.assertAll();

        actions.dragAndDrop(elements.get(0), elements.get(5))
                .build()
                .perform();

        softAssertions.assertThat(elements.get(0).getText()).isEqualTo("Three");
        softAssertions.assertThat(elements.get(1).getText()).isEqualTo("Four");
        softAssertions.assertThat(elements.get(2).getText()).isEqualTo("Five");
        softAssertions.assertThat(elements.get(3).getText()).isEqualTo("Six");
        softAssertions.assertThat(elements.get(4).getText()).isEqualTo("One");
        softAssertions.assertThat(elements.get(5).getText()).isEqualTo("Two");

        softAssertions.assertAll();
    }
}
