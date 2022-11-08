package com.workenlive.module.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(name = "email")
    //@CacheLookup
    WebElement txtEmail;

    @FindBy(name = "password")
    //@CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@class= 'login-btn']")
    //@CacheLookup
    WebElement btnLogin;

    @FindBy(linkText= "Logout")
    //@CacheLookup
    WebElement lnkLogout;

    public void setUserName(String username)
    {
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }

    public void setPassword(String password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clicksubmit()
    {
        btnLogin.click();

    }
}
