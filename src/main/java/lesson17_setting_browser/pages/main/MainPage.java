package lesson17_setting_browser.pages.main;

import lesson17_setting_browser.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath ="//*[@id='content']/div/h4")
    private WebElement successfulMessage;

    public String getSuccessfulMessage(){
        return successfulMessage.getText();
    }

    public MainPage (){
        super();
    }
}
