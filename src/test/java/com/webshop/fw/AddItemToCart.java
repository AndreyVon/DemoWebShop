package com.webshop.fw;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase{

    @BeforeMethod
    public void LogIn(){
        logIn();
    }

    @Test
    public void BayStaff(){
        click(By.xpath("(//input[@value='Add to cart'])[2]"));
        click(By.cssSelector("[class='cart-label']"));
        Assert.assertTrue(isStafInShoppingCart());
        deleteStaff();


    }

}
