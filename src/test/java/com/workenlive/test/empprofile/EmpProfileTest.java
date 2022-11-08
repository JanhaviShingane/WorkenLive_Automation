package com.workenlive.test.empprofile;

import com.workenlive.base.BaseClass;
import com.workenlive.module.empprofile.EmpProfile;
import com.workenlive.module.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmpProfileTest extends BaseClass
{
    @Test(priority=1)
    public void EmpProfile() throws IOException, InterruptedException
    {
        driver.get(baseURL);
        driver.manage().window().maximize();

        LoginPage lp = new LoginPage(driver);

        lp.setUserName(username);
        lp.setPassword(password);
        lp.clicksubmit();

        driver.getTitle().equals("Workenlive-Demo");

        Thread.sleep(1000);

        EmpProfilePage empess = new EmpProfile()Page(driver);

        empess.clickEmpEssencial();
        empess.clickEmpManagement();
        Thread.sleep(1000);
        empess.clickAddEmp();

        driver.getTitle().equals("Workenlive-Demo");


        if(driver.getTitle().equals("Workenlive-Demo"))
        {
            Assert.assertTrue(true);
            //Logger.info("TestCase Passed");
            //Thread.sleep(5000);
        }
        else
        {
            captureScreen(driver, "myservices");
            Assert.assertTrue(false);
            //Logger.info("TestCase Failed");
        }


    }
}

