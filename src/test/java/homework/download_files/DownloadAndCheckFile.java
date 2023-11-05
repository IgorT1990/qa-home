package homework.download_files;

import lesson17_setting_browser.utils.MyFileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


public class DownloadAndCheckFile extends BaseTestClassProperties{
    @Test
    public void downloadFile() throws IOException, InterruptedException {
        File file = MyFileUtils.generateLoremFile();
        goUrl();

        WebElement inputArea = driver.findElement(By.id("textbox"));
//        String text = FileUtils.readLines(new File(file.getAbsolutePath()), Charset.defaultCharset()).toString();

        String text = FileUtils.readFileToString(new File(file.getAbsolutePath()));
        inputArea.sendKeys(text);
        driver.findElement(By.id("create")).click();

        Assert.assertTrue(driver.findElement(By.id("link-to-download")).isDisplayed());

        driver.findElement(By.id("link-to-download")).click();
        Thread.sleep(1000);


        File downloadedFile = new File("/Users/itaranukha/Downloads/easyinfo.txt");
        String downloadedContent = FileUtils.readFileToString(downloadedFile, "UTF-8");

        String uploadedContent = FileUtils.readFileToString(file, "UTF-8");

        Assert.assertEquals(downloadedContent, uploadedContent);

        downloadedFile.deleteOnExit();
    }
}
