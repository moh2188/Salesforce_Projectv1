package Utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import BaseClass.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repName="Test-Report"+ timestamp+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkReporter.config().setDocumentTitle("Salesforce Automation Report");//report title
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Salesforce Test Project");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub module", "Customers");
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviornment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operting System", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includegroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includegroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includegroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+" got successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+" got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		String imgpath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		/*try {
			URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
			//Create the email message
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googleemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("mohsinkabli7@gmail.com","Ott@w@2412"));
			email.setSSLOnConnect(true);
			email.setFrom("mohsinkabli7@gmail.com");// sender
			email.setSubject("Test Results");
			email.setMsg("Please find attached report");
			email.addTo("mohsinkabli21@gmail.com");// receiver
			email.attach(url, "extent report", "please check report..");
			email.send();
		}
		catch(Exception e){
			e.printStackTrace();
		}*/	
		
		
	}

}


