package com.ait.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void findElementByTagName(){
        WebElement h3 = driver.findElement(By.tagName("h3"));
        System.out.println(h3.getText());

        List<WebElement> li = driver.findElements(By.tagName("li"));
        System.out.println(li.size());

        List<WebElement> span = driver.findElements(By.tagName("span"));
        System.out.println(span.size());
    }

    @Test
    public void searchElements(){
        driver.findElements(By.cssSelector("[class='inactive'] [href='/books']"));
        driver.findElement(By.cssSelector("div.item-box:nth-child(2) div.buttons > *"));
        driver.findElement(By.cssSelector("[href='/register']"));
        driver.findElement(By.cssSelector("[value='Search']"));
        driver.findElement(By.cssSelector("div.header-menu li [href='/computers']"));

    }

    @Test
    public void searchElementXPath(){

        driver.findElement(By.xpath("//*[@href='/register']"));
        driver.findElement(By.xpath("//*[@value='Search']"));
        driver.findElement(By.xpath("//*[@class='inactive'] //*[@href='/books']"));
        driver.findElement(By.xpath("(//div[@class='item-box'])[1]//div[@class='buttons']/*"));
        driver.findElement(By.xpath("//*[@class='top-menu']//*[@href='/computers']"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
