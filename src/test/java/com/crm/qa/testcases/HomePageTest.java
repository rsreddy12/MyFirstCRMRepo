package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		MainPage mainPage = new MainPage();
		loginPage = mainPage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void nameLableDisplayedTest() {
		Boolean flag = homePage.verifyNameLableDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=2)
	public void homePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Homepage title is incorrect");
	}
	
	@Test (priority=3)
	public void verifyContactsLinkTest() throws InterruptedException {
		contactsPage = homePage.ClickOnContacts();
		Thread.sleep(2000);
	}
	
	@Test (priority=4)
	public void verifyDealsLinkTest() throws InterruptedException {
		dealsPage = homePage.ClickOnDeals();
		Thread.sleep(2000);
	}
	
	@Test (priority=5)
	public void verifyTasksLinkTest() throws InterruptedException {
		tasksPage = homePage.ClickOnTasks();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

