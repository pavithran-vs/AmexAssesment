package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.CommonMethods;
import utility.Log;

//listener class for logging events
public class TestListener implements ITestListener {
	
	@Override
    public void onTestStart(ITestResult result) {
        Log.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error(" Test Failed: " + result.getName());
        Log.error(" Failure Reason: " + result.getThrowable().getMessage());
        ITestContext context = result.getTestContext(); 
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver"); 

        if (driver != null) {
            CommonMethods common = new CommonMethods(driver);
            common.takeScreenshot(result.getName()); 
        } else {
            Log.error("WebDriver instance is still null. Check context setup.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.warn(" Test Skipped: " + result.getName());
    }
}
