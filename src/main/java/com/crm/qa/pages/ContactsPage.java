package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(xpath ="//input[@class='search' and @type='text']")
	WebElement companyName;
	
	@FindBy(xpath ="//input[@name='value' and @type='text']")
	WebElement emailId;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/button[2]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyLable(String lable) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+lable+"')]")).isDisplayed();
	}
	
	public void selectContact(String conName) {
	//driver.findElement(By.xpath("//td[contains(text(),'"+conName+"')]//parent::td[class]//preceding-sibling::input[@name='id']")).click();
	driver.findElement(By.xpath("//td[contains(text(),'"+conName+"')]")).click();
	}

	public void createNewContact(String fname, String lname, String mname, String company, String email) {
		newContactBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		middleName.sendKeys(mname);
		companyName.sendKeys(company);
		emailId.sendKeys(email);
		saveBtn.click();
	}
	
}
