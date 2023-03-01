package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		By amazonDevicesLink = By.partialLinkText("Amazon Devices");
		String hrefValue = getAttributeValue(amazonDevicesLink, "href");
		System.out.println(hrefValue);
		if(hrefValue.contains("footer_devices")) {
			System.out.println("this is correct href");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String getAttributeValue(By locator, String attrName) {
		String attrValue = getElement(locator).getAttribute(attrName);
		System.out.println(attrValue);
		return attrValue;
	}

}
