package homework.product_sorting;

import lesson17_setting_browser.driver.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.util.Base64;

public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        takeScreenshot();
    }

    private void takeScreenshot() {
        String screenshotBase64 = getScreenshotAsBase64();
        Reporter.log("<br><img src='data:image/png;base64, " + screenshotBase64 + "' height='400' width='700'/><br>");
    }

    private String getScreenshotAsBase64() {
        WebDriver driver = WebDriverHolder.getInstance().getDriver();
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return Base64.getEncoder().encodeToString(screenshot);

    }
}

