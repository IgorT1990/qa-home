package lesson17_setting_browser.pages.upload_page;

import lesson17_setting_browser.driver.WebDriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {

    @FindBy(id = "textbox")
    private WebElement textArea;

    @FindBy(id = "create")
    private WebElement generateButton;

    @FindBy(id = "link-to-download")
    private WebElement uploadButton;

    public UploadPage(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public void uploadFile(String text){
        textArea.click();
        textArea.sendKeys(text);
    }

    public boolean generateButtonActive(){
        return generateButton.isDisplayed();
    }

    public void generateFile(){
        generateButton.click();
    }

    public boolean isDownloadLinkAppears(){
        return uploadButton.isDisplayed();
    }

    public void downloadFile(){
        uploadButton.click();
    }

}
