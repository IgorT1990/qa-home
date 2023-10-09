package classwork.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    private static final String USER_NAME = "tomsmith";
    private static final String USER_PASS = "SuperSecretPassword!";

    @BeforeMethod
    public void Start(){
        driver = new ChromeDriver();
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
        WebElement userNameFiled = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement userPassField = driver.findElement(By.xpath("//*[@id='password']"));

        userNameFiled.clear();
        userNameFiled.sendKeys(USER_NAME);

        userPassField.clear();
        userPassField.sendKeys(USER_PASS);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        WebElement textLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        Assert.assertEquals(textLogin.getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }


}

