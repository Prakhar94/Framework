package com.self.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver testdriver) {
		this.driver = testdriver;
	}
	
	@FindBy(name= "email") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(className="submit") WebElement loginButton;
	@FindBy(xpath = "//a/span[contains(text(),'Log In')]") WebElement SignInButton;
	
	public void signIn(String uname, String pwd){
		SignInButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		
	}

}
