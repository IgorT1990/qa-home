package homework.page_object;

import lesson17_setting_browser.pages.upload_page.UploadPage;
import lesson17_setting_browser.utils.MyFileUtils;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFiles extends BaseTestPageObject{

   @BeforeMethod
    public void beforeMethod(){
       goToUrl();
   }

   @Test
    public void uploadAndCheckFile() throws IOException, InterruptedException {

       // First part (generate file and convert to string)
       File file = MyFileUtils.generateLoremFile();
       String text = FileUtils.readFileToString(file, "UTF-8");

       // Second part (use methods from uploadPage)
       UploadPage uploadPage = new UploadPage();
       uploadPage.uploadFile(text);

       Assert.assertTrue(uploadPage.generateButtonActive());

       uploadPage.generateFile();
       Assert.assertTrue(uploadPage.isDownloadLinkAppears());

       uploadPage.downloadFile();
       Thread.sleep(5000);

       // Third part (compare downloaded files)
       File downloadedFile = new File("/Users/itaranukha/Downloads/easyinfo.txt");
       String downloadedContent = FileUtils.readFileToString(downloadedFile, "UTF-8");

       String uploadedContent = FileUtils.readFileToString(file, "UTF-8");

       Assert.assertEquals(downloadedContent, uploadedContent);

       downloadedFile.deleteOnExit();



   }
}
