package com.workenlive.webdrivers;

public class DriverFactory
{
    public static WebDriverImpl selectBrowser(String browser)
    {
        WebDriverImpl impl = null;
        if(browser.equals("chrome")) {
            impl = new ChromeDriverClass();
        } else if(browser.equals("firefox")) {
            impl = new FirefoxDriverClass();
        } else if(browser.equals("edge")) {
            impl = new EdgeDriverClass();
        }

        return impl;
    }
}

