package ru.gb.lesson.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthTests extends BaseTest {


    @Test
    void authByUiTest() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        webDriver.findElement(By.name("username")).sendKeys("tomsmith");
        webDriver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'You logged into a secure area!')]")));
    }

    @Test
    void authByCookieTest() {
        webDriver.get("http://the-internet.herokuapp.com/login");

        webDriver.manage().addCookie(new Cookie("rack.session", "BAh7CkkiD3Nlc3Npb25faWQGOgZFVEkiRTFjYTAyNjE0NjNmMWNhNjMxMTkx%0AOGQ4NWFhNjg3ZWIxZTgzZWZlM2Q0ZTI4ZWYyYjNiM2U0NWNmY2I3ZDU1ZjgG%0AOwBGSSIJY3NyZgY7AEZJIiU3MDk5ZmQ4YmI1YzcyYzI2Y2QxZmVjYmZkYjkw%0ANjA1YgY7AEZJIg10cmFja2luZwY7AEZ7B0kiFEhUVFBfVVNFUl9BR0VOVAY7%0AAFRJIi04OTk3MzNlMzFmN2JlNGI3NmFjMjc0YWQ0NmI3ZDgxOTg4M2FhYzQz%0ABjsARkkiGUhUVFBfQUNDRVBUX0xBTkdVQUdFBjsAVEkiLWM2OWVjOTEzYTg1%0AY2UyMmNjNmM4NjJmYWRlZjdmNWFhMmM2M2JmODkGOwBGSSIKZmxhc2gGOwBG%0AewBJIg11c2VybmFtZQY7AEZJIg10b21zbWl0aAY7AFQ%3D%0A--11f4862ac37872e3586de7e9537a9c7669dfeece"));

        webDriver.get("http://the-internet.herokuapp.com/secure");
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Secure Area')]")));
    }



    @Test
    void basicAuthTest() {
        webDriver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'You must have the proper credentials.')]")));
    }
}
