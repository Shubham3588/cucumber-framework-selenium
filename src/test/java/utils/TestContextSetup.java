package utils;

import org.openqa.selenium.WebDriver;

import managers.WebDriverManager;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	private WebDriver driver;
	private PageObjectManager pageobjectmanager;
	
	WebDriverManager manager = new WebDriverManager();
	

	
	public TestContextSetup() {
		driver = manager.getDriver();
		pageobjectmanager = new PageObjectManager(driver);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageobjectmanager;
	}
	
	public void closeDriver() {
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	

}
