package com.webshop.fw;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccaunt extends  TestBase {

    @Test
    public void registrationPositiveTest(){

        clickRegisterButton();
        registerForm();
        doneRegister();
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='ico-logout']")));

    }

    private void doneRegister() {
        click(By.cssSelector("[value='Register']"));
    }

    private void clickRegisterButton() {
        click(By.cssSelector("[href='/register']"));
    }

    public void registerForm() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        type(By.cssSelector("#FirstName"), "Andrey");
        type(By.cssSelector("[name='LastName']"), "Bu");
        type(By.cssSelector("[name='Email']"), "ggvonbdoy" + i + "@gmail.com");
        type(By.cssSelector("[name='Password']"), "Iamlovekedy21$");
        type(By.cssSelector("[name='ConfirmPassword']"), "Iamlovekedy21$");
    }
}
