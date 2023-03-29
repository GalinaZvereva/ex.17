package SetUp.Android;

import SetUp.Android.SetUp;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods extends SetUp {

    public Methods(AndroidDriver driver) {
        this.driver = driver;
    }

    protected void waitElement(By by, String error_message)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.withMessage(error_message);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitAndClickElement(By by){
        waitElement(by, "Element not found");
        driver.findElement(by).click();
    }
    protected void waitAndFillText(By by, String text){
        waitElement(by, "Element not found");
        driver.findElement(by).sendKeys(text);
    }
    protected void assertElementHasResult(By by)
    {
        waitElement(by, "Element not found");
        List element = driver.findElements(by);
        System.out.println(element.size());
        Assert.assertTrue(" Result not equals", 5 == element.size());
    }
    protected void assertSearchIsEmpty(By by){
        List element = driver.findElements(by);
        Assert.assertTrue("Search not empty", element.isEmpty());
    }
    protected void waitAndClear(By by){
        waitElement(by, "Element not found");
        driver.findElement(by).clear();
    }
    protected void longPressElement(By by){
        waitElement(by, "Cant found this element");
        TouchAction longPress = new TouchAction<>(driver);
        WebElement article = driver.findElement(by);
        longPress.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(article))).perform();
    }
    protected void assertCountOfArticles(){
        WebElement element = driver.findElement(By.xpath("//*[@resource-id='org.wikipedia:id/item_reading_list_statistical_description']"));
        System.out.println(element.getText());
        Assert.assertTrue("You have more than one articles", element.getText().contains("1 of 1"));
    }
    protected void assertTitle(String errorMessage)
    {
        WebElement title = driver.findElement(By.id("org.wikipedia:id/view_page_title_text"));
        System.out.println(title.getText());
        Assert.assertTrue(errorMessage, title.getText().contains("Romeo"));
    }
}
