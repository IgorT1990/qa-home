package classwork.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTestClass{
        private static final String USER_NAME = "tomsmith";
        private static final String USER_PASS = "SuperSecretPassword!";
        private final static Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);


        @Test
        public void loginTestWithXpath(){
            LOGGER.info("Start checking login");
            WebElement userNameFiled = driver.findElement(By.xpath("//*[@id='username']"));
            WebElement userPassField = driver.findElement(By.xpath("//*[@id='password']"));

            userNameFiled.clear();
            userNameFiled.sendKeys(USER_NAME);

            userPassField.clear();
            userPassField.sendKeys(USER_PASS);

            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
            loginButton.click();

            LOGGER.info("Finish checking login");
            WebElement textLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
            Assert.assertEquals(textLogin.getText(), "Welcome to the Secure Area. When you are done click logout below.");
        }

        @Test
    public void loginTestWithCSS(){
            WebElement userNameFiled = driver.findElement(By.cssSelector("#username"));
            WebElement userPassField = driver.findElement(By.cssSelector("#password"));

            userNameFiled.clear();
            userNameFiled.sendKeys(USER_NAME);

            userPassField.clear();
            userPassField.sendKeys(USER_PASS);

            WebElement loginButton = driver.findElement(By.cssSelector("i[class^=fa]"));
            loginButton.click();

            WebElement textLogin = driver.findElement(By.cssSelector("#content>div>h4"));
            Assert.assertEquals(textLogin.getText(), "Welcome to the Secure Area. When you are done click logout below.");
        }
    }



