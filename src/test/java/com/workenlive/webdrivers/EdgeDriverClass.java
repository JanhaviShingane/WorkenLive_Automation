package com.workenlive.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverClass implements WebDriverImpl
{
    public WebDriver getBrowserDriver() {
        return new EdgeDriver();
    }
}

