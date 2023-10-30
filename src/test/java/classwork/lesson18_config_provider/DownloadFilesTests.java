package classwork.lesson18_config_provider;

import lesson17_setting_browser.utils.MyFileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DownloadFilesTests extends BaseTestClassUseProperties{

    @Test
    public void downloadTest() throws IOException, InterruptedException {
        File file = MyFileUtils.generateLoremFile();
        goToPart("uploadUrl");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), file.getName());

        goToPart("downloadUrl");
        driver.findElement(By.linkText(file.getName())).click();

        File file1 = MyFileUtils.waitTillFileIsLoaded(new File("", file.getName()));

        Assert.assertEquals(file.length(), file1.length());

        file1.deleteOnExit();
    }
}
