package com.workenlive.module.empprofile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmpProfile
{
    WebDriver ldriver;

    public EmpProfiles(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


    @FindBy(how = How.XPATH, using= "//span[@class= 'pro-item-content' and contains(text(), 'Employee Essentials')]")
    @CacheLookup
    WebElement btnempessentials;

    @FindBy(how = How.XPATH, using= "//div[@class= 'menutext' and contains(text(), 'Employee Management')]")
    @CacheLookup
    WebElement btnempmanagement;

    @FindBy(how = How.XPATH, using= "//pre[contains(text(), 'Add Employee')]")
    @CacheLookup
    WebElement btnaddemp;

    public void clickEmpProfile()
    {
        btnempessentials.click();
    }

    public void clickEmpManagement()
    {
        btnempmanagement.click();
    }

    public void clickAddEmp()
    {
        btnaddemp.click();
    }


}
