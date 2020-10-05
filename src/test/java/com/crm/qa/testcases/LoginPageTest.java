package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	 public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod(timeOut = 30000)
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title =loginPage.verifyTitleOfPage();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority = 1)
	public void crmLogoTest() {
		Boolean b =loginPage.crmImagecheck();
		//Assert.assertEquals(b, "true");
		Assert.assertTrue(b);
		
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homepage =loginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
