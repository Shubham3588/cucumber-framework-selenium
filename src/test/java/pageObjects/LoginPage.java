package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.LoginSteps;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebDriver driver ;
	
	
	
	private By emailField = By.xpath("//*[starts-with(@id,'userEmail')]");
	private By passwordField = By.xpath("//*[contains(@id,'userPassword')]");
	private By loginButton = By.id("login");
	private By toastMessage = By.xpath("//*[contains(text(),'Login Successfully')]");
	
	
	public void enterEmail(String email) {
		WaitUntilVisibilityOfElement(emailField).sendKeys(email);
		
		
	}
	
	public void enterPassword(String password) {
		WaitUntilVisibilityOfElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginButton() {
		WaitUntilVisibilityOfElement(loginButton).click();
	}
	
	public String getToastMessage() {		
		String actualMessage = WaitUntilVisibilityOfElement(toastMessage).getText();
		return actualMessage;
	}

}