package classwork.lesson19_page_object;

import lesson17_setting_browser.driver.WebDriverHolder;
import lesson17_setting_browser.utils.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){
        WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterSuite(){
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url){
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl(){
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url"));
    }

    public void goToPart(String part){
        goToUrl(ConfigProvider.getInstance().getProperty("app.base.url") + part);
    }



}
