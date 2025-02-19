package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCard extends TesteBase{
    @BeforeMethod
    public void logIn(){
        inputEmail();
        inputPassword();
    }

    @Test
    public void addToCard(){
        click(By.cssSelector("div.item-box:nth-child(3) div.buttons > *"));
        clousedAssertInBay();
        pause(500);
        click(By.cssSelector("li:nth-child(3) [class='ico-cart']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='cart-item-row']")));

        deleteProduct();


    }
}
