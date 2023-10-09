package classwork.lesson12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewAlertsTests {
    private WebDriver driver;

    @BeforeClass
    public void Start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void Stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void alertTest() {
        clickAlertButton();

        workWithAlert(true);

        String result = getResult();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    public void confirmTest() {
        clickConfirmButton();

        workWithAlert(true);

        String result = getResult();
        Assert.assertEquals(result, "You clicked: Ok");

    }
    @Test
    public void dismissTest() {
        clickConfirmButton();

        workWithAlert(false);

        String result = getResult();
        Assert.assertEquals(result, "You clicked: Cancel");

    }
    @Test
    public void promptTestOk() {
        clickPromptButton();
        String textToEnter = "Test String!";

        workWithAlert(true, textToEnter);

        String result = getResult();
        Assert.assertEquals(result, "You entered: " + textToEnter);
    }

    @Test
    public void promptTestCancel() {
        clickPromptButton();
        String textToEnter = "Test String!";

        workWithAlert(false, textToEnter);

        String result = getResult();
        Assert.assertEquals(result, "You entered: null");
    }

    private void clickOnButtons(Buttons button){
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(), '" + button.getText() + "')]"));
        alertButton.click();
    }

    public String getResult(){
        return driver.findElement(By.id("result")).getText();
    }

    public String workWithAlert(boolean accept, String... textToEnter){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        if (textToEnter.length > 0){
            alert.sendKeys(textToEnter[0]);
        }
        if (accept){
            alert.accept();
        }
        else {
            alert.dismiss();
        }
        return text;
    }

    public void clickAlertButton(){
        clickOnButtons(Buttons.ALERT);
    }
    public void clickConfirmButton(){
        clickOnButtons(Buttons.CONFIRM);
    }
    public void clickPromptButton(){
        clickOnButtons(Buttons.PROMPT);
    }

    enum Buttons {
        ALERT("Click for JS Alert"),
        CONFIRM("Click for JS Confirm"),
        PROMPT("Click for JS Prompt");

        private String text;
        Buttons(String s){
            this.text = s;
        }
        public String getText(){
            return text;
        }
    }
}





