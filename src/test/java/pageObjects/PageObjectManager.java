package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private LoginPage loginpage;
	
	public  PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	


	public LoginPage getLoginPage() {
		if(loginpage==null) {
			loginpage = new LoginPage(driver);
		}
		
		return loginpage;
	}
	

}
