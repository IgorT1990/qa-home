package classwork.lesson18_config_provider;

import lesson17_setting_browser.utils.MyFileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class UploadFilesTests extends BaseTestClassUseProperties{

    @Test
    public void uploadTest() throws IOException {
        File file = MyFileUtils.generateLoremFile();
        goToPart("upload");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("download");
        Assert.assertTrue(driver.findElement(By.linkText(file.getName())).isDisplayed());
    }

}
