package lesson17_setting_browser.pages;

import lesson17_setting_browser.driver.WebDriverHolder;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public void sleep(long msec) throws InterruptedException{
        Thread.sleep(msec);
    }
}
