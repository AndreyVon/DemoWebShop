package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {

    static WebDriver driver;
    String browser;
    UserHelper user;
    ProductHelper product;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    public void init() {
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();

        }if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }


        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        product = new ProductHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ProductHelper getProduct() {
        return product;
    }

    public static void stop() {
        driver.quit();
    }

}
