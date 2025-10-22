package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;



public class WebDriverManager{
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		
	String browser = ConfigReader.getProperty("browser").toLowerCase();
	
	switch(browser) {
	case "firefox":
		driver = new FirefoxDriver();
		
		break;
		
	  case "edge":
          System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
          driver = new EdgeDriver();
         
          break;
	
	
	case "chrome":
		defaut:
		driver=new ChromeDriver();
		
		break;
	
}
	
	
	
	driver.manage().window().maximize();
	return driver;
	}
}
