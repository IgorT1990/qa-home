package classwork.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollDemo {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
    public void beforeMethod(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.w3schools.com/xml/xpath_axes.asp");
            wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        }

        @AfterMethod
    public void afterMethod(){
            if (driver != null){
                driver.quit();
            }
        }

        @Test
    public void Test(){
       //     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accept-choices']"))).click();
       //   wait.until(ExpectedConditions.elementToBeClickable(By.id("accept-choices"))).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            driver.findElement(By.xpath("//*[@id='spacemyfooter']/div[3]/div[2]/a[6]")).click();

            Assert.assertEquals(driver.getTitle(), "W3.CSS Reference");

        }

}
