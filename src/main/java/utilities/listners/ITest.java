package utilities.listners;

import utilities.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;

import static utilities.CaptureScreenshot.getScreenShotPath;


public class ITest implements ITestListener {

    private final Logger log = LogManager.getLogger(ITest.class);
    private final ExtentReports extentReports = ExtentReporter.getReportObject();
    private ExtentTest test;
    private WebDriver driver;
    private final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();


    @Override
    public void onTestStart(@NotNull ITestResult iTestResult) {
        test = extentReports.createTest(iTestResult.getMethod().getMethodName());
        threadLocal.set(test);
        log.info("Starting test: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(@NotNull ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " passed successfully");
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(@NotNull ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " failed");
        test.fail("Test failed");
        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            threadLocal.get().addScreenCaptureFromPath("."+getScreenShotPath(iTestResult.getMethod().getMethodName(),driver),iTestResult.getMethod().getMethodName());
            getScreenShotPath(iTestResult.getName(),driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(@NotNull ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " skipped");
        test.skip("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Test failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext iTestResult) {
        log.info("Test started");
    }

    @Override
    public void onFinish(ITestContext iTestResult) {
        log.info("The tests finished");
        extentReports.flush();
        threadLocal.remove();
    }

}
