package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait  wait;
	private static final long DEFAULT_TIMEOUT=10;
	
	public  BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
	}
	
	protected WebElement WaitUntilVisibilityOfElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected List<WebElement> WaitUntilVisibilityOfListElements(By locator){
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	protected void waitForInvisibility(By locator) {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	protected WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	protected WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


	
	
	

}

