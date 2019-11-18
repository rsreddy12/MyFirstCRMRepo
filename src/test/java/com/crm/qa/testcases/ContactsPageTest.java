package com.crm.qa.testcases;

import org.testng.Assert; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		MainPage mainPage = new MainPage();
		loginPage= mainPage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.ClickOnContacts();
		Thread.sleep(2000);
	}
	
	@Test(priority=1, enabled=false)
	public void verifyLableTest() {
		Boolean flag = contactsPage.verifyLable("Contacts");
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2, enabled=false)
	public void selectContactTest() {
		contactsPage.selectContact("SHANKAR REDDY RAGIREDDY");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("Contacts");
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validteNewContactsTest(String fname, String lname, String maname, String company, String email) {
		contactsPage.createNewContact(fname, lname, maname, company, email);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
