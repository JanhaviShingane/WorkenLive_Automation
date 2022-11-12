package com.workenlive.base;

import com.workenlive.utils.ConfigRead;
import com.workenlive.utils.ExtentReportManager;
import com.workenlive.webdrivers.DriverFactory;
import com.workenlive.webdrivers.WebDriverImpl;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners(ExtentReportManager.class)
public class TestBase
{
    ConfigRead configread = new ConfigRead();

    public String baseURL = configread.getApplicationURL();
    public String username = configread.getUsername();
    public String password = configread.getPassword();


    public WebDriver driver;
    public static Logger Logger;

    @BeforeClass
    public void setup()
    {
        Logger = Logger.getLogger("workenlive");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @BeforeMethod
    public void initialSetup() {
        WebDriverImpl impl = DriverFactory.selectBrowser(configread.getBrowserName());
        driver = impl.getBrowserDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        Logger.info("URL is Opened");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");

    }
}


