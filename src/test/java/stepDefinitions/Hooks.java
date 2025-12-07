package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.WebDriverManager;
import pageObjects.PageObjectManager;
import utils.ConfigReader;
import utils.TestContextSetup;


public class Hooks {
	private TestContextSetup textcontextsetup;
	  private int retryCount = 0;
	    private static final int maxRetryCount = 2;
	
	  public Hooks(TestContextSetup testContextSetup) {
	        this.textcontextsetup = testContextSetup;
	    }
	
	
	@Before()
	public void setup() {
		
		
		textcontextsetup.getDriver().get(ConfigReader.getProperty("baseUrl"));
		
		
		
	}
	
	@After()
		public void tearDown() {
		textcontextsetup.closeDriver();
		}
	
	
	
	public TestContextSetup getTestContext() {
		return textcontextsetup;
	}
	

	
	

	

}
