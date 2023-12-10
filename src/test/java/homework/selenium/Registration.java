package homework.selenium;

import lesson17_setting_browser.driver.WebDriverHolder;
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

public class Registration  extends  Base{
    private static final String EMAIL = "tester.testovui+6@gmail.com";
    private static final String INVALIDEMAIL = "test@test.com";
    private WebDriverWait wait;
    private Duration timeout;


    @Test
    public void CreateAccount() throws InterruptedException {
        WebElement email = WebDriverHolder.getInstance().getDriver().findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement createButton = WebDriverHolder.getInstance().getDriver().findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));

        email.click();
        email.clear();
        email.sendKeys(EMAIL);
        createButton.click();

        timeout = Duration.ofSeconds(2);
        wait = new WebDriverWait(WebDriverHolder.getInstance().getDriver(), timeout);
        WebElement successPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noSlide\"]/h1")));
        Assert.assertEquals(successPage.getText(), "AUTHENTICATION");

    }

    @Test
    public void invalidEmail(){
        WebElement email = WebDriverHolder.getInstance().getDriver().findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement createButton = WebDriverHolder.getInstance().getDriver().findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));

        email.click();
        email.clear();
        email.sendKeys(INVALIDEMAIL);
        createButton.click();

        WebElement errorDisplaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"create_account_error\"]")));
        Assert.assertEquals(errorDisplaying.getText(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }
}