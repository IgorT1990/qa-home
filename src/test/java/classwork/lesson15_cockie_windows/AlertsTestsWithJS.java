package classwork.lesson15_cockie_windows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTestsWithJS {
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

    // Test section general

    @Test
    public void alertTest() {
        clickAlertButton();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    public void confirmTestOk() {
        clickConfirmButton();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You clicked: Ok");
    }

    @Test
    public void confirmTestCancel() {
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

    // Test section with executing JS script

    @Test
    public void alertTestJS(){
        pressAlertButton();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    public void confirmTestOkJS(){
        pressConfirmButton();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You clicked: Ok");
    }

    @Test
    public void confirmTestCancelJS() {
        pressConfirmButton();
        workWithAlert(false);
        String result = getResult();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void promptTestOkJS() {
        pressPromptButton();
        String textToEnter = "Test String!";
        workWithAlert(true, textToEnter);
        String result = getResult();
        Assert.assertEquals(result, "You entered: " + textToEnter);
    }

    @Test
    public void promptTestCancelJS() {
        pressPromptButton();
        String textToEnter = "Test String!";
        workWithAlert(false, textToEnter);
        String result = getResult();
        Assert.assertEquals(result, "You entered: null");
    }

    // Test section with executing JS script on button

    @Test
    public void alertTestClickWithJS(){
        clickAlertButtonWithJS();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    public void confirmTestOkClickWithJS(){
        clickConfirmButtonWithJS();
        workWithAlert(true);
        String result = getResult();
        Assert.assertEquals(result, "You clicked: Ok");
    }

    @Test
    public void confirmTestCancelClickWithJS() {
        clickConfirmButtonWithJS();
        workWithAlert(false);
        String result = getResult();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void promptTestOkClickWithJS() {
        clickPromptButtonWithJS();
        String textToEnter = "Test String!";
        workWithAlert(true, textToEnter);
        String result = getResult();
        Assert.assertEquals(result, "You entered: " + textToEnter);
    }

    @Test
    public void promptTestCancelClickWithJS() {
        clickPromptButtonWithJS();
        String textToEnter = "Test String!";
        workWithAlert(false, textToEnter);
        String result = getResult();
        Assert.assertEquals(result, "You entered: null");
    }

    // JS get result
    @Test
    public void promptTestOkJSText() {
        String textToEnter = "Test String!";
        clickPromptButton();
        workWithAlert(true, textToEnter);
        String result = getResultJS();
        Assert.assertEquals(result, "You entered: " + textToEnter);
    }

    // Methods

    private void clickOnButtons(Buttons button){
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(), '" + button.getText() + "')]"));
        alertButton.click();
    }

    private void pressOnButtonWithJS(Buttons button) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("return " + button.jsScript);
    }

    private void clickOnButtonWithJS(Buttons button) {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'" + button.getText() + "')]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("return arguments[0].click();", alertButton);
    }

    public String getResult(){
        return driver.findElement(By.id("result")).getText();
    }

    // JS get results
    public String getResultJS(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("return document.getElementById('result').textContent").toString();
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

    // Clicks on buttons
    public void clickAlertButton(){
        clickOnButtons(Buttons.ALERT);
    }
    public void clickConfirmButton(){
        clickOnButtons(Buttons.CONFIRM);
    }
    public void clickPromptButton(){
        clickOnButtons(Buttons.PROMPT);
    }

    // JS Executing
    public void pressAlertButton(){
        pressOnButtonWithJS(Buttons.ALERT);
    }
    public void pressConfirmButton(){
        pressOnButtonWithJS(Buttons.CONFIRM);
    }
    public void pressPromptButton(){
        pressOnButtonWithJS(Buttons.PROMPT);
    }

    // Clicks on buttons with JS
    public void clickAlertButtonWithJS(){
        clickOnButtonWithJS(Buttons.ALERT);
    }
    public void clickConfirmButtonWithJS(){
        clickOnButtonWithJS(Buttons.CONFIRM);
    }
    public void clickPromptButtonWithJS(){
        clickOnButtonWithJS(Buttons.PROMPT);
    }


    enum Buttons {
        ALERT("Click for JS Alert", "jsAlert()"),
        CONFIRM("Click for JS Confirm", "jsConfirm()"),
        PROMPT("Click for JS Prompt", "jsPrompt()");

        private String text;
        private String jsScript;

        Buttons(String string, String jsScript){
            this.text = string;
            this.jsScript = jsScript;
        }

        public String getText(){
            return text;
        }
    }
}

