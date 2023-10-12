package homework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String EMAIL = "tester.testovui+6@gmail.com";
    private static final String INVALIDEMAIL = "test@test.com";

    @BeforeMethod
    public void Start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterMethod
    public void Stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void CreateAccount() {
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));

        email.click();
        email.clear();
        email.sendKeys(EMAIL);
        createButton.click();

        WebElement successPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noSlide\"]/h1")));
        Assert.assertEquals(successPage.getText(), "AUTHENTICATION");

    }

    @Test
    public void invalidEmail(){
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));

        email.click();
        email.clear();
        email.sendKeys(INVALIDEMAIL);
        createButton.click();

        WebElement errorDisplaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]")));
        Assert.assertEquals(errorDisplaying.getText(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }
}