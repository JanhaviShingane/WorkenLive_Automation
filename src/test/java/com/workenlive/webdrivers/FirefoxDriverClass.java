package com.workenlive.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverClass implements WebDriverImpl
{
    public WebDriver getBrowserDriver() {
        return new FirefoxDriver();
    }
}
