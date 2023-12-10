package homework.hellocucumber.src.test.java.hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class StepDefinitions {
    private WebDriver driver;

    private static final String USER_NAME = "tomsmith";
    private static final String USER_PASS = "SuperSecretPassword!";
    private static final String LOGIN_URL = "https://the-internet.herokuapp.com/login";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("the login page is opened")
    public void theLoginPageIsOpened() {
        driver.get(LOGIN_URL);
    }

    @When("I enter the login credentials")
    public void enterLoginCredentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(USER_PASS);
    }

    @And("I click on the login button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    @Then("I see the successful login message")
    public void successfulMessage() {
        WebElement successNotification = driver.findElement(By.xpath("//div[@id='flash' and contains(@class, 'success')]"));
        String successText = successNotification.getText();
        Assert.assertTrue(successText.contains("You logged into a secure area"), "Login not successful");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
