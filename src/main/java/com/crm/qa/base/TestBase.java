package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public Properties prop;
	EventFiringWebDriver e_driver;
	WebDriverEventListener eventListener;

	public TestBase() {
		try {
		prop= new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\STrange\\eclipse-workspace\\POMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fs);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browser= prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Files\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
