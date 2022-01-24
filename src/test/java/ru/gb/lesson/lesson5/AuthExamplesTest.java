package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthExamplesTest extends BasicTest{


    @Test
    void authWithUiTest() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        webDriver.findElement(By.name("username")).sendKeys("tomsmith");
        webDriver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        new WebDriverWait(webDriver, 4).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Secure Area')]")));
    }

    @Test
    void authWithCookieTest() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        webDriver.manage().deleteAllCookies();
        webDriver.manage().addCookie(new Cookie("rack.session", "BAh7CkkiD3Nlc3Npb25faWQGOgZFVEkiRWZmMTE1ODg0ZWQ3YzE0NzU5MDky%0AZGZhMWVjZjE1OWFkN2UzNzdkMzM4NWIyYWQzZmQyYmMwOGI3ODNiNGE0MDEG%0AOwBGSSIJY3NyZgY7AEZJIiU4MWYxNDRiZWY3YWE0NzYyMDk2OGMyYzFhMmY3%0AMjY1OAY7AEZJIg10cmFja2luZwY7AEZ7B0kiFEhUVFBfVVNFUl9BR0VOVAY7%0AAFRJIi0zZmNhNmYxY2ViOTVmNTQ2MzEwZTdlZjFiZDFlYTdjYWJlYjYyNWVm%0ABjsARkkiGUhUVFBfQUNDRVBUX0xBTkdVQUdFBjsAVEkiLWM2OWVjOTEzYTg1%0AY2UyMmNjNmM4NjJmYWRlZjdmNWFhMmM2M2JmODkGOwBGSSIKZmxhc2gGOwBG%0AewBJIg11c2VybmFtZQY7AEZJIg10b21zbWl0aAY7AFQ%3D%0A--f3f5f22d098f832f7d026c954042ff268685af34"));
        webDriver.get("http://the-internet.herokuapp.com/secure");

        new WebDriverWait(webDriver, 4).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Secure Area')]")));

    }


    @Test
    void basicAuthTest() {
        webDriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        new WebDriverWait(webDriver, 4).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Congratulations! You must have the proper credentials.')]")));
    }
}
