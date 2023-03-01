package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		//		System.out.println(linkList.size());
		//		
		//		for(int i=0; i<linkList.size(); i++) {
		//			String linkText = linkList.get(i).getText();
		//			if(!linkText.isEmpty()) {
		//				System.out.println(linkText);
		//			}
		//		}

		//		for(WebElement e : linkList) {
		//			String text = e.getText();
		//			if(!text.isEmpty()) {
		//				System.out.println(text);
		//			}
		//		}

		By link1 = By.tagName("a");
		List<WebElement> linkList1 = getElements(link1);

		for (WebElement e : linkList1) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

}
