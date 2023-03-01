package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		Thread.sleep(5000);
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Port Alberni, Canada']"));
		
		String aqNum = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(aqNum);
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		String city = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(city);
		
		String placeHolder = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(placeHolder);
		
		String nearbyValue = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearbyValue);
		
		
	}

}
