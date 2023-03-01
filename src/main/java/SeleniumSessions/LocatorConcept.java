package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// Create the Webelement + User actions (Click, Sendkeys, gettext, displayed)

		//		 //1. ID
		//		 
		//		 driver.findElement(By.id("input-email")).sendKeys("noor@gmail.com");
		//		 driver.findElement(By.id("input-password")).sendKeys("Noor@123");
		//		 
		//		 //2nd
		//		 
		//		 WebElement emailId = driver.findElement(By.id("input-email"));
		//		 WebElement password  = driver.findElement(By.id("input-password"));
		//		 
		//		 emailId.sendKeys("noor@gmail.com");
		//		 emailId.sendKeys("Noor@123");
		//		 //Logout
		//		 
		//		 emailId.sendKeys("Naveen@gmail.com");

		//		 //3rd : By Locator
		//		 
		//		 By username  =By.id("input-email");
		//		 By pwd  = By.id("input-password");
		//		 
		//		 WebElement emailId = driver.findElement(username);
		//		 WebElement password = driver.findElement(pwd);
		//		 
		//		 emailId.sendKeys("Noor123#gmail.com");
		//		 password.sendKeys("Noor123");

		//		// 4th: By Locator with Generic Method (getElement())
		//
		//		By username = By.id("input-email");
		//		By pwd = By.id("input-password");
		//
		//		getElement(username).sendKeys("Noor@gamil.com");
		//		getElement(pwd).sendKeys("Noor123");


		//5th: By locator with generic method with actions

		//		By username = By.id("input-email");
		//		By pwd = By.id("input-password");
		//		doSendKeys(username, "Noor@gmail.com");
		//		doSendKeys(pwd, "Noor123");

		//6th: ElementUtil class with generic methods
		//		By username = By.id("input-email");
		//		By pwd = By.id("input-password");
		//		
		//		ElementUtil eleUtil = new ElementUtil(driver);
		//		eleUtil.doSendKeys(username, "Noor@gmail.com");
		//		eleUtil.doSendKeys(pwd, "Noor123");		

		//7th : String locator values
		String username = "input-email";
		String pwd = "input-password";
	
		doSendKeys("id", username, "Naveen@gmail.com");
		doSendKeys("id", pwd, "Naveen@123");
		


	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			System.out.println("Please pass the right locator type and value");
			break;
		}

		return locator;

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public static void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);

	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {

		getElement(locatorType, locatorValue).sendKeys(value);

	}

}
