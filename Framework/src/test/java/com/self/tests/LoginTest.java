package com.self.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.self.pages.Base;
import com.self.pages.LoginPage;
import com.self.utility.BrowserFactory;
import com.self.utility.ExcelDataProvider;
import com.self.utility.Helper;

public class LoginTest extends Base {
	
	@Test
	public void startApp(){
		logger = report.createTest("Login into Application");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Logging into Application.");
		login.signIn(documentReader.readStringFromODS(0, 0, 0), documentReader.readStringFromODS(0, 1, 0));
		logger.pass("Login Successful!");
		
	}
	
	@Test (priority=1)
	public void logout(){
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Logout from application.");
//		login.signIn("abc", "xyz");
		logger.fail("logout failed!");
	}

}
