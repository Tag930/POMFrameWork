package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory -- Page Objects
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement Logo;
	
	//Initialization the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean crmImagecheck() {
		return Logo.isDisplayed();
	}
	
	public HomePage LoginTest(String un, String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		LoginBtn.click();
		
		return new HomePage();
	}

}
