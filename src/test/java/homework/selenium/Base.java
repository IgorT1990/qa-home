package homework.selenium;

import lesson17_setting_browser.driver.WebDriverHolder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
    @BeforeSuite
    public void beforeSuite(){
        WebDriverHolder.getInstance().getDriver();
        WebDriverHolder.getInstance().getDriver().manage().window().maximize();
        WebDriverHolder.getInstance().getDriver().get("http://prestashop.qatestlab.com.ua/en/authentication?back=my-account#account-creation");

    }

    @AfterSuite
    public void afterSuite(){
        WebDriverHolder.getInstance().driverQuit();
    }
}
