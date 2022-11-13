package com.workenlive.base;

import com.workenlive.webdrivers.DriverFactory;
import com.workenlive.webdrivers.WebDriverImpl;
import org.openqa.selenium.WebDriver;

public class TestContext {
    // Variables declaration
    private static TestContext object;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    // Private constructor to create class instance inside this class only
    private TestContext() {

    }

    // Static method which will get called everywhere to get class instance
    public static TestContext getInstance() {
        if(object == null) {
            object = new TestContext();
        }

        return object;
    }

    // This method is used to set ThreadLocal of WebDrivers using Factory method design pattern
    public final void setWebDriver(String browser) {
        WebDriverImpl impl = DriverFactory.selectBrowser(browser);
        WebDriver driver = impl.getBrowserDriver();
        webDriver.set(driver);
    }

    // This method is used to get WebDriver instance from ThreadLocal of WebDriver
    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    // This method is used to remove WebDriver instance from ThreadLocal of WebDriver
    public void removeWebDriver() {
        try {
            webDriver.get().quit();
        }catch (Exception e) {
            // TODO: handle exception
        }

        webDriver.remove();
    }
}
