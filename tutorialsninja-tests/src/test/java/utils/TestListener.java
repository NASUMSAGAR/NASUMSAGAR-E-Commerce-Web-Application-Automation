// utils/TestListener.java
package utils;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
        System.out.println("Test Suite Finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        // read browser parameter from testng XML
        String browser = result.getTestContext()
                               .getCurrentXmlTest()
                               .getParameter("browser");
        if (browser == null) browser = "chrome";

        // createTest now takes (testName, browser) — matches updated ExtentReportManager
        ExtentReportManager.createTest(
                result.getMethod().getMethodName(), browser);

        ExtentReportManager.getTest()
                .log(Status.INFO, "Test Started — Thread: "
                        + Thread.currentThread().getId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
        ExtentReportManager.clearThreadLocal();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest testInstance = (BaseTest) result.getInstance();
        String screenshotPath = testInstance.captureScreenshot(
                result.getMethod().getMethodName());

        ExtentReportManager.getTest()
                .addScreenCaptureFromPath(screenshotPath)
                .fail("Test Failed: " + result.getThrowable().getMessage()
                        + "\nThread ID: " + Thread.currentThread().getId()
                        + "\nStack Trace: " + getStackTrace(result.getThrowable()));

        ExtentReportManager.clearThreadLocal();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest()
                .log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        ExtentReportManager.clearThreadLocal();
    }

    private String getStackTrace(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : throwable.getStackTrace())
            sb.append(element.toString()).append("\n");
        return sb.toString();
    }
}