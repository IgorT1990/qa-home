package classwork.lesson19_page_object;

import lesson17_setting_browser.pages.login.LoginPage;
import lesson17_setting_browser.pages.main.MainPage;
import lesson17_setting_browser.utils.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String userName = ConfigProvider.getInstance().getProperty("login.tests.username");
    String userPassword = ConfigProvider.getInstance().getProperty("login.tests.password");

    @BeforeMethod
    public void beforeMethod(){
        goToPart("login");
    }

    @Test
    public void successfulLogin(){
        MainPage mainPage = new LoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test
    public void unsuccessfulLogin(){
        LoginPage loginPage = new LoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");

        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }
}
