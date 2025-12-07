package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.BrowserType;
import utils.ConfigReader;



public class WebDriverManager{
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
		
	String browser = ConfigReader.getProperty("browser");
	
	  BrowserType browserType = BrowserType.fromString(browser);
	
	switch(browser) {
	case "FIREFOX":
		driver = new FirefoxDriver();
		
		break;
		
	  case "EDGE":
          System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
          driver = new EdgeDriver();
         
          break;
	
	
	case "CHROME":
		default:
		driver=new ChromeDriver();
		
		break;
		
	
	
}
	
	
	
	driver.manage().window().maximize();
	return driver;
	}
}
