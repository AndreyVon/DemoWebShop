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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
