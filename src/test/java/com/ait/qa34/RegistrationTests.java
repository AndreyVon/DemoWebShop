package com.ait.qa34;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TesteBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registrationFormPositiveTest(){
        app.getUser().clickRegisterLink();
        app.getUser().fillAddRegisterForm(new User()
                .setName("Andrey")
                .setLastName("DonDon")
                .setEmail("pampamG@gm.com")
                .setPassword("pampampam1213"));
        app.getUser().clickOnSaveRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[href='/customer/info']")));


    }


}
