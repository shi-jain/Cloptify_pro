package TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	 ExtentReports extent=ExtentReporterNG.getReportObject();
	@Override
	    public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
	 }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS,"Test Pass");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	      //test.fail(result.getThrowable());
	      try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	      String path=null;
	      try {
		 path=getScrennShot(result.getMethod().getMethodName(), driver);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	       // System.out.println(“Test skipped: ” + result.getName());
	    }
	    
	    public void onFinish(ITestContext context) {
	    	extent.flush();
	    	
	    }
}
