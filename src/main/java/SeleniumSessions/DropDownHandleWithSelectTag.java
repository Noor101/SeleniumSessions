package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelectTag {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		//		WebElement countryField = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		//		Select select = new Select(countryField);
		//		select.selectByIndex(4);
		//		select.selectByVisibleText("Anguilla");
		//	select.selectByValue("Bermuda");
		
		By country = By.xpath("//select[@id='Form_getForm_Country']");
		doDropDownSelectByIndex(country, 11);
		doDropDownSelectByValue(country, "Djibouti");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doDropDownSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
}
