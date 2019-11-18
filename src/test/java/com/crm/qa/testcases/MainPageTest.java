package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.pages.SignupPage;

public class MainPageTest extends TestBase {
	MainPage mainPage;
	LoginPage loginPage;
	SignupPage signupPage;
	
	public MainPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		mainPage = new MainPage();
	}
	
	@Test(priority=1)
	public void mainPageTitleTest() {
		String title = mainPage.validateMainPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small", "Main page title is incorrect");
	}
	
	@Test(priority=2)
	public void loginTest() {
		loginPage = mainPage.clickOnLogin();
	}
	
	@Test(priority=3)
	public void signupTest() {
		signupPage = mainPage.clickOnSignup();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
