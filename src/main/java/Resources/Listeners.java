package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {
    public ExtentTest Test;
    public ExtentReports extent = ExtentReport.getReport();
    @Override
    public void onTestStart(ITestResult result) {
        String MethodName = result.getMethod().getMethodName();
        Test = extent.createTest(MethodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Test.fail(result.getThrowable());
        WebDriver FailedDriver = null;
        String MethodName = result.getMethod().getMethodName();
        try {
            FailedDriver= (WebDriver)result.getTestClass().getRealClass()
                          .getDeclaredField("Driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Test.addScreenCaptureFromPath(getScreenshot(MethodName,FailedDriver),MethodName);
//            Test.fail(MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(MethodName,FailedDriver)).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    extent.flush();
    }
}
