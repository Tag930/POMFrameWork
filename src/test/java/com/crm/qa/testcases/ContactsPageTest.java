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
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	static String sheetname="Contacts";
	
	 public ContactsPageTest() {
		super();
	}
	
	 
	 @BeforeMethod()
	 public void ContactsCheck() {
		 initialization();
		 loginpage = new LoginPage();
		 homepage = new HomePage();
		 contactpage = new ContactsPage();
		 testutil = new TestUtil();
		 homepage=loginpage.LoginTest(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		 
	 }
	 
	 @Test(priority=1)
	 public void clickContactcheckbox() throws InterruptedException {
		
		 homepage.clickOnContacts();
		 //boolean b = contactpage.ContactsCheckboxclick();
		 contactpage.selectContactByName("amit");
		 contactpage.selectContactByName("Andrew Max");
		 boolean b = contactpage.verifyContactnameCheck("amit");
		 boolean c = contactpage.verifyContactnameCheck("Andrew Max");
		 Thread.sleep(6000);
		 Assert.assertTrue(b,"Contactname could not be verified");
		 Assert.assertTrue(c,"Contactname could not be verified");
	 }
	 
	 @DataProvider
	 public Object[][] getCRMTestData() {
		 Object data[][]=TestUtil.getTestData(sheetname);
		 return data;
	 }
	 
	 @Test(priority=0,dataProvider = "getCRMTestData")
	 public void validateCreateNewContact(String Title,String firstname,String lastname,String company) {
		 homepage.clickonnewcontact();
		 contactpage.createNewContact(Title, firstname, lastname, company);
	 }
	 
	
	 
	 
	 @AfterMethod
	 public void teardown() {
		 driver.quit();
	 }

}
