package homework.download_files;

import lesson17_setting_browser.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClassProperties {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass(){
        if (driver == null){
            driver.quit();
        }
    }

    public void goUrl(String url){
        driver.get(url);
    }

    public void goUrl(){
        goUrl(ConfigProvider.getInstance().getProperty("uploadUrl"));
    }
}
