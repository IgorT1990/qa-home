package lesson17_setting_browser.driver;
import lesson17_setting_browser.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;
    private final static String BROWSER = System.getProperty("browser", "chrome");


    public static WebDriver getDriver(Browser browser){
        switch (browser){
            case CHROME -> {
                return getChromeDriver();
            }
            case FIREFOX -> {
                return getFirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Wrong type of browser provided. Choose are: chrome, firefox");
        }
    }

    public static WebDriver getDriver(){
        driver = getDriver(Browser.valueOf(BROWSER.toUpperCase()));
        return driver;
    }

    private static WebDriver getChromeDriver() {
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null){
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
