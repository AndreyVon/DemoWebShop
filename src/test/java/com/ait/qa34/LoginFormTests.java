package com.ait.qa34;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormTests extends TesteBase{


    @Test
    public void signInLoginPositiveTest(){
        clickLoginBytton();
        inputEmail();
        inputPassword();
        clickInSaveLogin();
    }
    @Test
    public void signInLoginNegativeTest(){
        clickLoginBytton();
        inputPassword();
        clickInSaveLogin();
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='validation-summary-errors']")));
    }


}
