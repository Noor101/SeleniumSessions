package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		//
		int fieldsCount = driver.findElements(By.className("text")).size();
		if(fieldsCount == 0) {
			System.out.println("form fields are not available");
		}
		else {
			System.out.println("form fields is available");
		}

		//To verify the single element

		By firstName = By.id("Form_getForm_FullName");
		boolean flag = driver.findElement(firstName).isDisplayed();
		System.out.println(flag);


		if(driver.findElements(firstName).size() >=1) {
			System.out.println("first name field is present");
		}
		else
		{
			System.out.println("fields are not available");
		}
		
		System.out.println(isElementExist(firstName));
	}
	
	public static boolean isElementExist(By locator) {
		int elementCount = driver.findElements(locator).size();
		System.out.println("Total elemnts found: "+ elementCount);
		if(elementCount >= 1) {
			System.out.println("The element is found" + locator);
			return true;
		}
		else {
			System.out.println("The element is not present" + locator);
			return false;
		}
	}

}
