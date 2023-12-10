package classwork.lesson12;

import lesson17_setting_browser.driver.WebDriverHolder;
import lesson17_setting_browser.pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginTests {
    private WebDriver driver;
//    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginTests.class);

    private static final String USER_NAME = "tomsmith";
    private static final String USER_PASS = "SuperSecretPassword!";

    @BeforeMethod
    public void Start(){
        WebDriverHolder.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void Stop(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void loginTestWithXpath(){
         //LOGGER.info("Start check login");
        WebElement userNameFiled = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement userPassField = driver.findElement(By.xpath("//*[@id='password']"));

        userNameFiled.clear();
        userNameFiled.sendKeys(USER_NAME);

        userPassField.clear();
        userPassField.sendKeys(USER_PASS);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

//        LOGGER.info("Finish check login");
        WebElement textLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        Assert.assertEquals(textLogin.getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }


}

