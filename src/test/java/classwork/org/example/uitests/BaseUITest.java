package classwork.org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BaseUITest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void Start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        driver.get("https://www.google.com/?hl=en-US");
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("webdriver");
        List<WebElement> webElementList = driver.findElements(By.name("btnK"));
        webElementList.get(1).click();

        Assert.assertEquals(driver.getTitle(), "webdriver - Google Search");


    }

    @AfterTest
    public void Stop(){
        driver.quit();
    }


}

