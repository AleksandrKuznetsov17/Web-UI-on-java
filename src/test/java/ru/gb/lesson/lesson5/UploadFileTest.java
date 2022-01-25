package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UploadFileTest extends BaseTest {

    @Test
    void uploadFileTest() throws InterruptedException {
        webDriver.get("http://the-internet.herokuapp.com/upload");
        webDriver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/dimakar/GB/january/lessons-gb-ui-autotests/src/test/resources/logback.xml");
        Thread.sleep(3000);
    }
}
