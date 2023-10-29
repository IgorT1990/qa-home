package classwork.lesson16_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitersTests extends BaseTestClass {
    @Test
    public void waiterTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.id("start")).findElement(By.xpath(".//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        Assert.assertEquals(driver.findElement(By.cssSelector("#finish > h4")).getText(), "Hello World!");
    }

    @Test
    public void waiterCustomTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.id("start")).findElement(By.xpath(".//button")).click();

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.id("loading")).size() > 0;
            }
        });

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver){
                return driver.findElement(By.id("loading")).isDisplayed();
            }
        });

        Assert.assertEquals(driver.findElement(By.cssSelector("#finish > h4")).getText(), "Hello World!");
    }
}

