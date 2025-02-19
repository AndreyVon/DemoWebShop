package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TesteBase {

    @Test
    public void registrationFormPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"),"Andrey");
        type(By.id("LastName"),"DonDon");
        type(By.id("Email"),"pampamG" + i + "@gm.com");
        type(By.id("Password"),"pampampam1213");
        type(By.id("ConfirmPassword"),"pampampam1213");
        click(By.cssSelector("[value='Register']"));
       Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));


    }


}
