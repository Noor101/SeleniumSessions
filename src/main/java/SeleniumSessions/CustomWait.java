package SeleniumSessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//While loop - iteration not fixed
		//thread.sleep(1000) - static
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		By email = By.id("input-password11");
		
		retryingElement(email, 10, 3000).sendKeys("Noor");
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
			element = getElement(locator);
			break;
			}catch(NoSuchElementException e) {
				System.out.println("element is not found in attemps: " + attempts+ " : "+ locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			try {
				throw new Exception();
			}catch(Exception e) {
				System.out.println("element is not found exception.........tried for :" + timeOut+ "with interval of :" + attempts);
			}
		}
		
		return element;
	}
	
	public static WebElement retryingElement(By locator, int timeOut, long pollingTime) {
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
			element = getElement(locator);
			break;
			}catch(NoSuchElementException e) {
				System.out.println("element is not found in attemps: " + attempts+ " : "+ locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			try {
				throw new Exception();
			}catch(Exception e) {
				System.out.println("element is not found exception.........tried for :" + timeOut+ "with interval of :" + attempts);
			}
		}
		
		return element;
	}
}
