package lesson17_setting_browser.pages.login;

import lesson17_setting_browser.pages.BasePage;
import lesson17_setting_browser.pages.main.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(id="username")
    private WebElement userInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login\"]/button/i")
    private WebElement loginButton;

    @FindBy(id="flash")
    private WebElement errorMessage;

    public LoginPage(){
        super();
    }

    private LoginPage setUserName(String userName){
        return enterValueToWebElement(userInput, userName);
//        userInput.clear();
//        userInput.sendKeys(userName);
//        return this;
    }

    private LoginPage setUserPassword(String userPassword){
         return enterValueToWebElement(passwordInput, userPassword);
//        passwordInput.clear();
//        passwordInput.sendKeys(userPassword);
//        return this;
    }

    private LoginPage enterValueToWebElement(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        return this;
    }

    private void clickLoginButton (){
        loginButton.click();
    }

    public MainPage login(String userName, String userPassword){
        setUserName(userName)
                .setUserPassword(userPassword)
                .clickLoginButton();
        return new MainPage();
    }

    public LoginPage unsuccessfulLogin(String userName, String userPassword){
        setUserName(userName)
                .setUserPassword(userPassword)
                .clickLoginButton();
        return new LoginPage();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
