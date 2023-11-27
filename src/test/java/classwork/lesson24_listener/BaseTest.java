package classwork.lesson24_listener;

import lesson17_setting_browser.driver.WebDriverHolder;
import lesson17_setting_browser.utils.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

    @Listeners({TestListener.class})
    public class BaseTest {

        @BeforeSuite
        public void beforeSuite() {
            WebDriverHolder.getInstance().getDriver();
//        clearScreenshotsFolder();
        }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult result) {
//        if (!result.isSuccess()) {
//            makeScreenshot(result.getName() + new Date().getTime());
//        }
//    }

//    public File makeScreenshot(String screenshotName) {
//        WebDriver driver = WebDriverHolder.getInstance().getDriver();
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        File file = new File("screenshots", screenshotName + ".png");
//        try {
//            FileUtils.copyFile(screenshot, file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return file;
//    }

        @AfterSuite
        public void afterSuite() {
            WebDriverHolder.getInstance().driverQuit();
        }

        public void goToUrl(String url) {
            WebDriverHolder.getInstance().getDriver().get(url);
        }

        public void goToUrl() {
            goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));
        }

        public void goToPart(String part) {
            goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
        }
    }

