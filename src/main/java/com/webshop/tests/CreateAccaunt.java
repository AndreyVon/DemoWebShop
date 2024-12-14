package com.webshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccaunt extends  TestBase {

    @Test
    public void registrationPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        click(By.cssSelector("[href='/register']"));
        type(By.cssSelector("#FirstName"), "Andrbey");
        type(By.cssSelector("[name='LastName']"), "Bu");
        type(By.cssSelector("[name='Email']"), "ggvonbdoy@gmail.com");
        type(By.cssSelector("[name='Password']"), "Iamlovekedy21$");
        type(By.cssSelector("[name='ConfirmPassword']"), "Iamlovekedy21$");

        click(By.cssSelector("[value='Register']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='ico-logout']")));




    }
}
