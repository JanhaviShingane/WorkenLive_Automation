package com.workenlive.base;

import com.workenlive.module.empprofile.EmpProfile;
import com.workenlive.module.loginpage.LoginPage;
import com.workenlive.utils.ConfigReader;
import com.workenlive.utils.ExtentReportManager;
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

    public static ConfigReader configread;
    public static String baseURL;
    public static String username;
    public static String password;
    public static String dbUsername;
    public static String dbPassword;
    public static String browser;
    protected LoginPage loginPage;
    protected EmpProfile empProfile;
    public static Logger logger;

    @BeforeSuite
    public void initialSetup()
    {
        logger = Logger.getLogger("workenlive");
        PropertyConfigurator.configure("Log4j.properties");

        configread = new ConfigReader();

        // Setting up browser
        initBrowser();

        // Setting up URL
        initURL();
    }

    @BeforeMethod
    public void testPrerequisiteSetup() {
        // Instantiate WebDriver instance
        TestContext.getInstance().setWebDriver(browser);
        WebDriver driver = TestContext.getInstance().getWebDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        logger.info("URL is Opened");

        // Instantiate module instances
        initModules();
        loginPage.setUserName(getUsername());
        logger.info("Entered Username : " + getUsername());
        loginPage.setPassword(getPassword());
        logger.info("Entered Password : " + getPassword());
        loginPage.clicksubmit();
    }

    @AfterMethod
    public void tearDown() {
        TestContext.getInstance().removeWebDriver();
        logger.info("Successfully terminated Webdriver");
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");

    }

    // This method is used to instantiate module instances
    public void initModules() {
        loginPage = new LoginPage(TestContext.getInstance().getWebDriver());
        empProfile = new EmpProfile(TestContext.getInstance().getWebDriver());
    }

    // This method is used to setup Browser
    public void initBrowser() {

        if (System.getProperty("browser") != null && !System.getProperty("browser").equals("")) {
            browser = System.getProperty("browser");
        } else {
            browser = configread.getBrowserName();
        }
    }

    // This method is used to setup URL
    public void initURL() {
        if(System.getProperty("baseURL") != null && !System.getProperty("baseURL").equals("")) {
            baseURL = System.getProperty("baseURL");
        } else {
            baseURL = configread.getApplicationURL();
        }
    }

    public String getUsername() {
        return configread.getUsername();
    }

    public String getPassword() {
        return configread.getPassword();
    }
}


