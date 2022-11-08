package com.workenlive.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.workenlive.constant.Constant;
import com.workenlive.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener
{
    // Variables declaration
    private static final ExtentTest extentTest = new ExtentTest();
    private static ExtentReports extent = new ExtentReports();

    // Annotated method will run once when test suite execution starts
    @Override
    public void onStart(ITestContext context) {

        // Instantiate extent report instance
         extent = ExtentReportManager.getExtentReport(System.getProperty("user.dir").replace("\\", "/") + Constant.extentReportFilePath);
    }

    //Annotated method will run when test case execution starts
    @Override
    public void onTestStart(ITestResult result) {
        String[] resultArr = result.getTestClass().getName().split("\\.");
        String className = resultArr[resultArr.length - 1];
        String testCase = result.getMethod().getMethodName();
        // Assign test case entry to report
        extentTest.set(extent.createTest(className + " > " + testCase).assignCategory(className));
    }

    //Annotated method will run when test case execution succeed
    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().info("Result Status: " + result.getStatus());
        extentTest.get().pass(String.valueOf(Status.PASS));
        extent.flush();

    }

    //Annotated method will run when test case execution failed
    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().info("Result Status: " + result.getStatus());
        extentTest.get().fail(String.valueOf(Status.FAIL));
        extentTest.get().fail(result.getThrowable());
        extent.flush();
    }

    //Annotated method will run when test case execution skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Result Status: " + result.getStatus());
        extentTest.get().log(Status.SKIP, result.getThrowable());
        extent.flush();
    }
}
