package com.workenlive.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverClass implements WebDriverImpl
{
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
