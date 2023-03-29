package Tests.mobile_web;


import SetUp.mobile_web.BaseTestSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Ex17 extends BaseTestSelenium {
    public Ex17(WebDriver driver) {
        super(driver);
    }

    public void clickOnBurgerMenu(){
        WaitAndClickElement(By.xpath("//label[@for='main-menu-input']"));
    }
    public void clickOnLogin(){
        WaitAndClickElement(By.xpath("//span[@class='mw-ui-icon-minerva-logIn mw-ui-icon']"));
    }
    public void fillTextInLogIn(String logIn){
        WaitAndWriteTextInElement(By.id("wpName1"),logIn);
    }
    public void fillTextInPass(String pass){
        WaitAndWriteTextInElement(By.id("wpPassword1"), pass);
    }
    public void pressLogInButton(){
        WaitAndClickElement(By.id("wpLoginAttempt"));
    }
    public void ClickOnSearchIcon(){
        WaitAndClickElement(By.id("searchIcon"));
    }
    public void fillTextInSearch(String text){
        WaitAndWriteTextInElement(By.xpath("//input[@class='search mw-ui-background-icon-search']"),text);
    }
    public void clickOnResult(String result){
        WaitAndClickElement(By.xpath("//li[@title='"+result+"']"));
    }
    public void addArticleInWatchList() throws InterruptedException {
        aWaiting();
        WaitAndClickElement(By.id("ca-watch"));
    }
    public void clickWatchList(){
        WaitAndClickElement(By.xpath("//span[@class='mw-ui-icon-minerva-watchlist mw-ui-icon']"));
    }
    public void deleteArticleFromWatchList(String article){
        WaitAndClickElement(By.xpath("//li[@title='"+article+"']//a[@aria-controls='mw-watchlink-notification']"));
    }
    public void refreshWatchPage() throws InterruptedException {
        refreshPage();
    }
    public void checkVisible(String result){
        checkThisValue(result);
    }

}
