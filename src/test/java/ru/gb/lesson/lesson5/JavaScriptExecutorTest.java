package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    void jsExampleTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        webDriver.get("https://demoqa.com/modal-dialogs");
        WebElement button = webDriver.findElement(By.id("showSmallModal"));
        js.executeScript("arguments[0].click()", button);
        WebElement window = webDriver.findElement(By.xpath("//div[contains(@class, 'modal-dialog')]"));
        js.executeScript("arguments[0].remove()", window);
        Thread.sleep(3000);
    }
}
