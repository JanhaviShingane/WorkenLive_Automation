package com.workenlive.test.loginpage;

import com.workenlive.base.TestBase;
import com.workenlive.base.TestContext;
import com.workenlive.module.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    @Test
    public void loginTest() throws IOException {

        TestContext.getInstance().getWebDriver().getTitle().equals("Workenlive-Demo");

        if(TestContext.getInstance().getWebDriver().getTitle().equals("Workenlive-Demo"))
        {
            Assert.assertTrue(true);
            logger.info("TestCase Passed");
        }
        else
        {
            captureScreen(TestContext.getInstance().getWebDriver(), "loginTest");
            Assert.assertTrue(false);
            logger.info("TestCase Failed");
        }
    }
}

