package com.webshop.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()> 0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }
        else {
            return true;
        }

    }
    public void logIn(){
        click(By.cssSelector("[class='ico-login']"));
        type(By.cssSelector("[name='Email']"), "ggvonbdoy@gmail.com");
        type(By.cssSelector("[name='Password']"), "Iamlovekedy21$");
        click(By.cssSelector("[value='Log in']"));
    }
    public boolean isStafInShoppingCart(){
        return isElementPresent(By.cssSelector("[class='end']"));
    }

    protected void deleteStaff() {
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[name='updatecart']"));
    }
}
