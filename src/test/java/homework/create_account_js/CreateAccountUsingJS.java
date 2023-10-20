package homework.create_account_js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class CreateAccountUsingJS extends BaseTClass {


    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void CreateAccount() {
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        email.sendKeys(EMAIL);
        javascriptExecutor.executeScript("return arguments[0].click();", createButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noSlide\"]/h1")));
        WebElement successPage = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1"));
        Assert.assertEquals(successPage.getText(), "AUTHENTICATION");

    }

    @Test
    public void scrollDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement linkContact = driver.findElement(By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[5]/a"));
        linkContact.click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
        Assert.assertEquals(text.getText(), "CUSTOMER SERVICE - CONTACT US");

    }
}
