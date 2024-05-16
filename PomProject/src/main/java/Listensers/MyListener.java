package Listensers;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.BaseClass;

public class MyListener implements ITestListener {

	public static ExtentReports extent=new ExtentReports();
	public static ExtentSparkReporter spark=new ExtentSparkReporter("target/Spark.html");
	public static ExtentTest test;


	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	@Override
	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage"+ result.getName());

	}

	@Override
	public  void onTestFailure(ITestResult result) 
	{
		
		String Click_Here_forScreenShot=null;
		try {
			Click_Here_forScreenShot= BaseClass.TakeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(spark);
		extent.createTest(result.getName().toUpperCase())
		.log(Status.FAIL,result.getName().toUpperCase()).log(Status.WARNING,result.getThrowable())
		.addScreenCaptureFromBase64String(Click_Here_forScreenShot);
		Reporter.log("Click to see ScreenShot");
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped"+ result.getName());
		extent.attachReporter(spark);
		extent.createTest(result.getName().toUpperCase())
		.log(Status.SKIP,result.getName().toUpperCase()+" is Skipped").log(Status.INFO,result.getThrowable());
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started "+ result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		extent.attachReporter(spark);
		extent.createTest(result.getName().toUpperCase())
		.log(Status.PASS,result.getName().toUpperCase()+" is Passed");
		extent.flush();

	}

}