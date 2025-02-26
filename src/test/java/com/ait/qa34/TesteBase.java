package com.ait.qa34;

import com.demowebshop.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TesteBase {

    protected static ApplicationManager app = new ApplicationManager();

    // @BeforeMethod
    @BeforeSuite
    public void setUp(){
        app.init();

    }

    // @AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown(){
        app.stop();
    }


}
