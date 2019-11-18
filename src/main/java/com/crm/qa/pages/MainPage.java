package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class MainPage extends TestBase {

	//Page Factory - OR
	//@FindBy(xpath= "/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")
	@FindBy(xpath= "//span[contains(text(),'Log In')]")
	WebElement login;
	
	//@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[1]/a")
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	//initializing page objects
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateMainPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickOnLogin() {
		login.click();
		return new LoginPage();
	}
	
	public SignupPage clickOnSignup() {
		signup.click();
		return new SignupPage();
		
	}
}