package homework.frames;

import classwork.lesson13.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTests extends BaseTestClass {
    @Test
    public void frameTests(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement framePage = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a"));
        framePage.click();

        String pageTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        Assert.assertEquals(pageTitle, "Frames");

        WebElement framesTypes = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a"));
        framesTypes.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/nested_frames");

        // Left frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        String bodyLeft = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyLeft, "LEFT");
        driver.switchTo().defaultContent();

        // Middle frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String bodyMiddle = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyMiddle, "MIDDLE");
        driver.switchTo().defaultContent();

        // Right frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");

        String bodyRight = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyRight, "RIGHT");
        driver.switchTo().defaultContent();

    }
}
