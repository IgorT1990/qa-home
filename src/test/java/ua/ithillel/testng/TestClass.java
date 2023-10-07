package ua.ithillel.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
public class TestClass {
WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/?hl=en-US");

    }

    @Test(priority = 1)
    public void FirstTest() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("hillel it school");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        Assert.assertTrue(elements.get(0).getText().toLowerCase().contains("hillel it school"), "Result doesn't match");

    }

    @Test(priority = 2)
    public void SecondTest() throws InterruptedException {
        driver.get("https://www.google.com/?hl=en-US");
        driver.findElement(By.name("q")).sendKeys("Linkedin test");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("//a/h3"));
        Assert.assertTrue(elements.get(0).getText().toLowerCase().contains("linkedin test"), "Result doesn't match");

    }

    @AfterTest
    public void Close(){
     driver.quit();
    }
}

