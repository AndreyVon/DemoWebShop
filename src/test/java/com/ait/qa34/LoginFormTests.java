package com.ait.qa34;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFormTests extends TesteBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void signInLoginPositiveTest(){
        app.getUser().clickLoginBytton();
        app.getUser().inputEmail();
        app.getUser().inputPassword();
        app.getUser().clickInSaveLogin();
    }
    @Test
    public void signInLoginNegativeTest(){
        app.getUser().clickLoginBytton();
        app.getUser().inputPassword();
        app.getUser().clickInSaveLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[class='validation-summary-errors']")));
    }


}
