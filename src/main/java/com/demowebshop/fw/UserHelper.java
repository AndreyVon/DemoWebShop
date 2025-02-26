package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void logInForm() {
        clickLoginBytton();
        inputEmail();
        inputPassword();
        clickInSaveLogin();
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
}
