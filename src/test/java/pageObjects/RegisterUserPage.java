package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterUserPage extends BasePage{
	
	private WebDriver driver;

	public RegisterUserPage(WebDriver driver) {
		super(driver);
		
	}
	
	private By nameField = By.xpath("//*[@placeholder='Name']");
	
	

}
