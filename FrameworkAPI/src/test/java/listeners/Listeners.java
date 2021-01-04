package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;

public class Listeners implements ITestListener{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onStart(ITestContext context) {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myDemoReport.html");
		htmlReporter.config().setDocumentTitle("First Extent Report");
		htmlReporter.config().setReportName("API Test Execution");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Method name:"+result.getName());
		test=extent.createTest(result.getName());
		test.log(Status.INFO,"Test has been started..."+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Method name:"+result.getName());
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test has been passed..."+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Method name:"+result.getName());	
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test has been failed..."+result.getName());
		test.log(Status.FAIL,"Test has been failed..."+result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Method name:"+result.getName());
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Tets has been skipped..."+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
