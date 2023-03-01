package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValueWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		//		List<WebElement> optionsList = driver.findElements(By.xpath("//select[@id='Form_getForm_Country']/option"));
		//		System.out.println(optionsList.size());
		//		
		//		for(WebElement e : optionsList) {
		//			String text = e.getText();
		//			if(text.equals("India")) {
		//				e.click();
		//				break;
		//			}
		//		}

	}

	public static void selectDropDownValuewWithoutSelect(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals("India")) {
				e.click();
				break;
			}

		}

	}

}
