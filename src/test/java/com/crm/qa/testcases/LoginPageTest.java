package com.crm.qa.testcases;

import org.testng.Assert; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class LoginPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		MainPage mainPage= new MainPage();
		loginPage = mainPage.clickOnLogin();
	}
		
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTilte();
		Assert.assertEquals(title,"Cogmento CRM", "Login page title is incorrect");
	}
	@Test(priority=2)
	public void loginTest() {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Alert alert= driver.switchTo().alert();
		//System.out.println(alert.getText());
		//alert.dismiss();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
