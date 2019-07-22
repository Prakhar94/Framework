package com.self.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import freemarker.template.SimpleDate;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotPath = System.getProperty("user.dir")+"/screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(screenshotPath));
		} catch (Exception e) {
			System.out.println("Unable to take screenshot: "+ e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}

}
