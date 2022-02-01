package ru.gb.lesson.lesson6.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import ru.gb.lesson.lesson6.pages.blocks.MainHeader;

public class BasePage extends BaseView {

    @Getter
    private MainHeader mainHeader = new MainHeader(webDriver);

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }
}
