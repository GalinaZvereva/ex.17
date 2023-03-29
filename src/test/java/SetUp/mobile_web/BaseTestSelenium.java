package SetUp.mobile_web;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestSelenium extends SetUpForSelenium {
    public BaseTestSelenium (WebDriver driver){
        this.driver = driver;
    }

    protected void setWait(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    protected void aWaiting() throws InterruptedException {
        Thread.sleep(1000);
    }
    protected void WaitAndClickElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    protected void WaitAndWriteTextInElement(By elementBy, String text){
        setWait(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
    protected void refreshPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();
    }
    protected void checkThisValue(String expectedValue){
        String value = getText(expectedValue,0);
        if (expectedValue.startsWith(expectedValue)){
            Assert.assertEquals("Title not visible",expectedValue,value);
            System.out.println("Verification was successful");
        }else {
            Assert.fail("Something wrong");
        }
    }
    protected String getText(String expectedValue,int x){
        String getText = driver.findElement(By.xpath("//li[@title='"+expectedValue+"']")).getText();
        String[] splited = getText.split("\\s");
        return splited[x];
    }

}
