package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TesteBase {

    @Test
    public void registrationFormPositiveTest(){
        clickRegisterLink();
        fillAddRegisterForm(new User()
                .setName("Andrey")
                .setLastName("DonDon")
                .setEmail("pampamG@gm.com")
                .setPassword("pampampam1213"));
        clickOnSaveRegistration();
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/customer/info']")));


    }


}
