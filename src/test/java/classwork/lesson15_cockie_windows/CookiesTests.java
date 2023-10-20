package classwork.lesson15_cockie_windows;

import classwork.lesson13.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CookiesTests extends BaseTestClass {

    private static final String USER_NAME = "tomsmith";
    private static final String USER_PASS = "SuperSecretPassword!";

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // Test cases
    @Test
    public void cookiesTest(){
      driver.findElement(By.id("username")).sendKeys(USER_NAME);
      driver.findElement(By.id("password")).sendKeys(USER_PASS);
      driver.findElement(By.cssSelector(".radius")).click();

      for (Cookie cookie : driver.manage().getCookies()){
          System.out.println(cookie.getName() + " " + cookie.getValue());
      }

        System.out.println("=====================");

      Cookie cookie = new Cookie("SomeCookie", "some val");
      driver.manage().addCookie(cookie);

      Cookie someCookie = driver.manage().getCookieNamed("SomeCookie");
      System.out.println(cookie.getName() + " " + cookie.getValue());
      driver.manage().deleteCookieNamed("SomeCookie");

      someCookie = driver.manage().getCookieNamed("SomeCookie");
        System.out.println(someCookie);

    }


}
