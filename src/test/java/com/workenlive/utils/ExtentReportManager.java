package com.workenlive.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    ExtentReports extent;
    ExtentSparkReporter reporter;
    ExtentTest test;
    //Beforesuite
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        reporter = new ExtentSparkReporter("target/Extent.html");
        extent.attachReporter(reporter);
    }

    //BeforeMethod
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getTestClass().getRealClass().getSimpleName() + " > " +result.getMethod().getMethodName());
    }

    //AfterMethod
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Passed: " + result.getClass().getName() + " > " + result.getMethod().getMethodName());
        test.pass("Test case Passed");
    }

    //AfterMethod
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Exception: " + result.getThrowable());
        test.fail("Test case Failed");
    }

    //AfterMethod
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Skipped: " + result.getThrowable());
        test.skip("Test case Skipped");
    }

    //AfterSuite
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }
}
