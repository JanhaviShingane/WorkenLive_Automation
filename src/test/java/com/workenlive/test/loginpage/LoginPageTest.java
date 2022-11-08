package com.workenlive.test.loginpage;

import com.workenlive.base.BaseClass;
import com.workenlive.module.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseClass
{
    @Test(priority=1)
    public void loginTest() throws IOException //InterruptedException
    {
        driver.get(baseURL);
        driver.manage().window().maximize();

        Logger.info("URL is Opened");

        LoginPage lp=new LoginPage(driver);

        lp.setUserName(username);
        Logger.info("Entered User Name");

        lp.setPassword(password);
        Logger.info("Entered Password");

        lp.clicksubmit();

        //Thread.sleep(20000);

        driver.getTitle().equals("Workenlive-Demo");

        if(driver.getTitle().equals("Workenlive-Demo"))
        {
            Assert.assertTrue(true);
            Logger.info("TestCase Passed");
        }
        else
        {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            Logger.info("TestCase Failed");
        }
    }
}

