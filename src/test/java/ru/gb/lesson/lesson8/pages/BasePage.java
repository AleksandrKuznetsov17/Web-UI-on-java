package ru.gb.lesson.lesson8.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import ru.gb.lesson.lesson8.pages.blocks.MainHeader;

public class BasePage {
    @Getter
    private MainHeader mainHeader = new MainHeader();
}
