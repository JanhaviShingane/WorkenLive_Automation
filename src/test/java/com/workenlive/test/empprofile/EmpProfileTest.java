package com.workenlive.test.empprofile;

import com.workenlive.base.TestBase;
import com.workenlive.base.TestContext;
import com.workenlive.module.empprofile.EmpProfile;
import com.workenlive.module.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmpProfileTest extends TestBase {
    @Test
    public void EmpProfile() throws IOException, InterruptedException {

        empProfile.clickEmpEssencial();
        empProfile.clickEmpManagement();
        Thread.sleep(1000);
        empProfile.clickAddEmp();

        TestContext.getInstance().getWebDriver().getTitle().equals("Workenlive-Demo");


        if(TestContext.getInstance().getWebDriver().getTitle().equals("Workenlive-Demo"))
        {
            Assert.assertTrue(true);
            //Logger.info("TestCase Passed");
            //Thread.sleep(5000);
        }
        else
        {
            captureScreen(TestContext.getInstance().getWebDriver(), "myservices");
            Assert.assertTrue(false);
            //Logger.info("TestCase Failed");
        }


    }
}

