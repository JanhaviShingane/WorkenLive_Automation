package com.workenlive.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverClass implements WebDriverImpl {
    public WebDriver getBrowserDriver() {
        return new ChromeDriver();
    }
}
