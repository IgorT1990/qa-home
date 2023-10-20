package homework.create_account_js;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTClass {
    WebDriver driver;
    WebDriverWait wait;

     static final String EMAIL = "tester.testovui+6@gmail.com";
     static final String INVALIDEMAIL = "test@test.com";

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        if (driver != null){
            driver.quit();
        }
    }

}
