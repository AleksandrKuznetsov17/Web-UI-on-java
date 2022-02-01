package ru.gb.lesson.lesson6.pages.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebDriver webDriver, WebElement webElement) {
        this.webElement = webElement;
    }
}
