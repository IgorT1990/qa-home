package classwork.lesson17_setting_browser;

import lesson17_setting_browser.driver.WebDriverFactory;
import lesson17_setting_browser.driver.WebDriverFactory2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass (){

//        System.setProperty("browser", "chrome");
        driver = WebDriverFactory2.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass (){
        if (driver != null){
            driver.quit();
        }
    }

        public static void main(String[] args) {
        System.getProperties().forEach((k, v) -> System.out.println(k + "   " + v));
   }
}
