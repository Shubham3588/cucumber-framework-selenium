package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class TestNGListeners implements ITestListener{

	 @Override
	    public void onTestStart(ITestResult result) {
		 System.out.println("I am from test Listener");
	        System.out.println("Starting scenario: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Scenario passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Scenario failed: " + result.getName());
	       
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Scenario skipped: " + result.getName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Starting Cucumber Test Suite");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("Finished Cucumber Test Suite");
	    }
	
	
	
	

}
