package classwork.lesson16_waits;

import io.netty.util.internal.ThreadExecutorMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTestClass{

    @Test
    public void BasicAuthTest() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Basic Auth");

        // First try
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("sessionStorage.clear();");
//        javascriptExecutor.executeScript("localStorage.clear();");

        // Second try
//        driver.manage().deleteAllCookies();

        // Third try
//        driver.get("chrome://settings/clearBrowserData");
//        Thread.sleep(3000);
//        WebElement bt = driver.findElement(By.xpath("//settings-ui"));
//        Thread.sleep(3000);
//        bt.sendKeys(Keys.ENTER);
//        Thread.sleep(3000);

        // Fourth try
        driver.get("chrome://settings/clearBrowserData");
//      String script = "return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#basicPage > settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog > div:nth-child(4) > #clearBrowsingDataConfirm')";
        String script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(10) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"#clearBrowsingDataConfirm\").click();";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement clearData = (WebElement) jse.executeScript(script);


        driver.get("https://the-internet.herokuapp.com/basic_auth");
//        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Basic Auth");

    }
}
