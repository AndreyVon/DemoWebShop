package com.ait.qa34;

import org.openqa.selenium.By;
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
        buyProduct(By.cssSelector("div.item-box:nth-child(3) div.buttons > *"));
        deleteProduct();


    }

}
