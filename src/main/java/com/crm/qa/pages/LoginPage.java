package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory - OR
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	@FindBy(xpath="//div[contains(text(), 'Login')]")
	WebElement loginButton;
	
	//initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateLoginPageTilte() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
}
