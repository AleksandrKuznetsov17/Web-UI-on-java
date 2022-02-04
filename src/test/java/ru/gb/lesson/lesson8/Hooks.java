package ru.gb.lesson.lesson8;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Hooks {


    @After
    public void tearDown() throws Exception {
        Selenide.closeWebDriver();
    }
}
