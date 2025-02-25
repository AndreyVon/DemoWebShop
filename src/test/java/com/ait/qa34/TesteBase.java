package com.ait.qa34;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Random;

public class TesteBase {
   static WebDriver driver;

    // @BeforeMethod
    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

   // @AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public void type(By locator, String text){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.alertIsPresent());
        if(alert == null) {
            return false;
        }else {
            return true;
        }
    }
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct() {
        click(By.cssSelector("td [type='checkbox']"));
        click(By.cssSelector("[name='updatecart']"));
    }

    public void inputPassword() {
        type(By.cssSelector("[name='Password']"),"pampampam1213");

    }

    public void clickInSaveLogin() {
        click(By.cssSelector("[class='button-1 login-button']"));
    }

    public void inputEmail() {

        type(By.cssSelector("[class='email']"),"pampamG1356@gm.com");
    }

    public void clickLoginBytton() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clousedAssertInBay() {
        click(By.cssSelector("[class='close']"));
    }



    public void buyProduct(By locator) {
        click(locator);
        clousedAssertInBay();
        pause(500);
        click(By.cssSelector("li:nth-child(3) [class='ico-cart']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='cart-item-row']")));
    }

    public void clickOnSaveRegistration() {
        click(By.cssSelector("[value='Register']"));
    }

    public void fillAddRegisterForm(User user) {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        type(By.id("FirstName"), user.getName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), i + user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }
}
