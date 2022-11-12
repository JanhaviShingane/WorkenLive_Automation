package com.workenlive.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    private ExtentReports extent;
    private ExtentSparkReporter reporter;
    private ExtentTest test;

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
        test.log(Status.PASS, "Result Status: " + result.getStatus());
        test.pass(String.valueOf(Status.PASS));
        extent.flush();
    }

    //AfterMethod
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Result Status: " + result.getStatus());
        test.fail(String.valueOf(Status.FAIL));
        test.fail(result.getThrowable());
        extent.flush();
    }

    //AfterMethod
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Result Status: " + result.getStatus());
        test.skip(String.valueOf(Status.SKIP));
        test.skip(result.getThrowable());
        extent.flush();
    }

    //AfterSuite
    public void onFinish(ITestContext context)
    {
        extent.flush();
    }
}
