package com.webshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;

    public ApplicationManager(String browser){
        this.browser = browser;

    }

    public  void init() {
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }

        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }



    public  void stop() {
        driver.quit();
    }

}
