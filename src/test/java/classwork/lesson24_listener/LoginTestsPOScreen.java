package classwork.lesson24_listener;

import lesson17_setting_browser.pages.login.LoginPage;
import lesson17_setting_browser.pages.main.MainPage;
import lesson17_setting_browser.utils.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsPOScreen extends BaseTest {
    String userName = ConfigProvider.getInstance().getProperty("login.tests.username");
    String userPassword = ConfigProvider.getInstance().getProperty("login.tests.password");

    @BeforeMethod
    public void beforeMethod() {
        goToPart("login");
    }

    @Test
    public void unsuccessfulLoginTest() {
        LoginPage loginPage = new LoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");
//        makeScreenshot("unsuccessfulLoginTest");
//        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
        // Навмисно робимо помилку
        Assert.assertNotEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

    @Test
    public void successfulLoginTest() {
        MainPage mainPage = new LoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "You logged into a secure area!\n" +
                "×");
    }

}