package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginSteps {
	public TestContextSetup testContextSetup;
	public LoginPage loginpage ;
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);
	
	   public LoginSteps(TestContextSetup context) {
	        this.testContextSetup = context;
	        this.loginpage = context.getPageObjectManager().getLoginPage();
	    }
	
	
	
	@Given("User navigates to the url")
	public void user_navigates_to_the_url() throws InterruptedException {
		logger.info("Opening URL");

	}
	@When("Screen Loads")
	public void screen_loads() {
	}
	@When("User enters {string} in email field")
	public void user_enters_email(String enterEmail) {
		testContextSetup.getPageObjectManager().getLoginPage().enterEmail(enterEmail);
		
	    
	}
	@When("User enters {string} in password Field")
	public void user_enters_password(String enterPassword) {
		
		testContextSetup.getPageObjectManager().getLoginPage().enterPassword(enterPassword);
		
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		testContextSetup.getPageObjectManager().getLoginPage().clickLoginButton();
	}
	@Then("Verify user landed to Homepage")
	public void verify_user_landed_to_homepage() {
	  
	   Assert.assertEquals(testContextSetup.getPageObjectManager().getLoginPage().getToastMessage(), "Login Successfully");
	}



}
