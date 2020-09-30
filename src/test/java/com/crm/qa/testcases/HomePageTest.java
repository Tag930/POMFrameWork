package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;




public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginPage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod(timeOut = 30000)
	public void setup() {
		initialization();
		//homepage= new HomePage();
		loginPage=new LoginPage();
		testutil = new TestUtil();
		contactspage= new ContactsPage();
		homepage =loginPage.LoginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle() {
		String title = homepage.verifyHomePageTitle();
		
		Assert.assertEquals(title, "CRMPRO","HomePage title not matched");
	}
	
	@Test(priority=0)
	public void verifyuser() {
		testutil.switchToFrame();
		Boolean b=homepage.verifyUSer();
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void verifyContactLink() {
		testutil.switchToFrame();
		contactspage=homepage.clickOnContacts();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
