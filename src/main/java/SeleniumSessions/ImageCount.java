package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println(imgList.size());
		
		for(int i=0; i<imgList.size();i++) {
			String altValue = imgList.get(i).getAttribute("alt");
			String srcValue = imgList.get(i).getAttribute("src");
			System.out.println(altValue + "-----------" + srcValue);
		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
