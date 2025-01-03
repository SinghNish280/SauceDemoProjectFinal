package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class ExtentReportManager1 implements ITestListener {


	public ExtentSparkReporter sparkReporter;  //UI of the report
	public ExtentReports extent;  //populate common info to the report
	public ExtentTest test;  //creating test case entries in the report and update status of the test methods

	String repName;
	
	public void onStart(ITestContext context) {
		
	/*	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentdatetimestamp = df.format(dt);
		
		*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-" +timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Broswer Name", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
		
	}
	
	public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test started: " + result.getMethod().getMethodName());
    }
	
	


	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName() + "got successfully executed");

	}



	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName() + "got FAILED" );
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} 
		catch(IOException e1) {
		e1.printStackTrace();
			
		}


	}



	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "got Skipped" );
		test.log(Status.INFO, result.getThrowable().getMessage());


	}
	
	
	public void onFinish(ITestContext context) {

		 extent.flush();
		 
		 String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		 File extentReport = new File(pathOfExtentReport);
		 
		 try {
			 Desktop.getDesktop().browse(extentReport.toURI());
			 
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 
		/* try {
			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
			//Create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("nishant720.kumar@gmail.com" , "password"));
			email.setSSLOnConnect(true);
			email.setFrom("nishant720.kumar@gmail.com"); //sender
			email.setSubject("Test Results");
			email.setMsg("Please find Attached Report...");
			email.addTo("nishant.singh13@infosys.com"); //Receiver
			email.attach(url, "extent report", "please check report...");
			email.send();
			
		 }
			 catch(Exception e) {
				 e.printStackTrace();
			 
			 
		 }
		 
		 */
		 
		  
	  }
	

}

