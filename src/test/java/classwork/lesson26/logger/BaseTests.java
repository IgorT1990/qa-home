package classwork.lesson26.logger;

import lesson17_setting_browser.driver.WebDriverHolder;
import lesson17_setting_browser.utils.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTests {
    @BeforeSuite
    public void beforeClass() {
        WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));
//        goToUrl(ConfigProvider.getInstance().getProperty("app.shop.url"));
    }

    public void goToPart(String part) {
//        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
    }
}

