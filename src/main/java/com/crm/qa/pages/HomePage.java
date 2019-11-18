package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Shankar Ragireddy')]")	
		WebElement nameLable;
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
		WebElement contacts;
	@FindBy(xpath="//span[contains(text(),'Deals')]")
		WebElement deals;
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
		WebElement tasks;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyNameLableDisplayed() {
		return nameLable.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage ClickOnContacts() {
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDeals() {
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasks() {
		tasks.click();
		return new TasksPage();
	}
	
 }
