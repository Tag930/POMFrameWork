package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement Contactslabel;


	@FindBy(xpath = "//*[@id='vContactsForm']//tr[6]//input")
	WebElement ChkBox;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//form[@name='contactForm']//following-sibling::table//input[2]")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean ContactsCheckboxclick() {
		//ChkBox.click();
		boolean c = ChkBox.isSelected();
		return c;

	}

	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td/input")).click();
		
	}
	
	public boolean verifyContactnameCheck(String name) {
		boolean c =driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td/input")).isSelected();
		return c;
		
	}
	
	public void createNewContact(String title,String firstname,String lastname,String company) {
		Select sct = new Select(this.title);
		sct.selectByVisibleText(title);
		
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.company.sendKeys(company);
		saveBtn.click();
		
	}

}
