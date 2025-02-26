package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCard extends TesteBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().logInForm();
    }

    @Test
    public void addToCard(){
        app.getProduct().buyProduct(By.cssSelector("div.item-box:nth-child(3) div.buttons > *"));
        app.getProduct().deleteProduct();


    }

}
