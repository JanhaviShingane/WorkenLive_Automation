package com.workenlive.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverClass implements WebDriverImpl
{
    public WebDriver getBrowserDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}

