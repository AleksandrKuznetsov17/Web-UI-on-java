package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowFramesAlertsTests extends BaseTest{

    @Test
    void alertsTest() {
        webDriver.get("https://demoqa.com/frames");
        webDriver.switchTo().frame(0);
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='This is a sample page']")));
        webDriver.switchTo().frame(1);
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='This is a sample page']")));
    }


    @Test
    void tabTest() {
        webDriver.get("https://demoqa.com/browser-windows");
        webDriver.findElement(By.id("tabButton")).click();

        List<String> tabs = List.copyOf(webDriver.getWindowHandles());

        assertThat(tabs).hasSize(2);
        webDriver.switchTo().window(tabs.get(1));
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='This is a sample page']")));
    }

    @Test
    void alertTest() throws InterruptedException {
        webDriver.get("https://demoqa.com/alerts");
        webDriver.findElement(By.id("alertButton")).click();

        webDriver.switchTo().alert()
                .accept();
        Thread.sleep(3000);
    }


}
