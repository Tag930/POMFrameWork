package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement User;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontact;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() {
		 contactsLink.click();
		 return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickOnTasks() {
		
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public boolean verifyUSer() {
		return User.isDisplayed();
		
	}
	
	public void clickonnewcontact() {
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		act.moveToElement(newcontact).click().build().perform();
		
	}

}
