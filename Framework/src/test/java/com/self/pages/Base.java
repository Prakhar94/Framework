package com.self.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.self.utility.BrowserFactory;
import com.self.utility.ConfigReader;
import com.self.utility.ExcelDataProvider;
import com.self.utility.Helper;
import com.self.utility.ODSDocumentReader;

public class Base {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigReader configReader;
	public ODSDocumentReader documentReader;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up the test and report is generated here!", true);
//		excel = new ExcelDataProvider();
		configReader = new ConfigReader();
		documentReader = new ODSDocumentReader();
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		Reporter.log("Setup complete!", true);
	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Launching browser!", true);
		driver = BrowserFactory.launchBrowser(driver, configReader.readDataFromConfig("Browser"),configReader.readDataFromConfig("qaUrl"));
		System.out.println("WebPage title is :-  "+ driver.getTitle());
		Reporter.log("Redirecting to test...", true);
	}
	
	@AfterClass
	public void tearDown() {
		Reporter.log("Closing the Browser here.", true);
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void getScreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			try {
				logger.fail("Test failed and screenshot attached!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("Screenshot not found for failed TC! "+ e.getMessage());
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
			try {
				logger.pass("Test passed and screenshot attached!", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("Screenshot not found for passed TC! "+ e.getMessage());
			}
		}
	}
	
	@AfterMethod
	public void flushLogsToReport() {
		Reporter.log("Flush logs to report for executed test!", true);
		report.flush();
	}
	
	
}
