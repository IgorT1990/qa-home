package classwork.lesson16_waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {
     WebDriver driver;
     WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void afterClass(){
        if (driver != null){
  //          driver.quit();
        }
    }

}

