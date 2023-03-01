package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345 ");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(5000);

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.xpath("//a[@title='Contacts']")).click();

		Thread.sleep(5000);
		
		
//		String webTableXpath = "//a[@_name='Georgia Foster']//parent::td//preceding-sibling::td/input";
		//a[text()='Harindar Test']/..preceding-sibling::td/child::input
//		driver.findElement(By.xpath(webTableXpath)).click();

		selectContact("Ligon Farber");
		selectContact("Georgia Foster");
		System.out.println(getCompanyName("Romi singh"));
		System.out.println(getContactPhoneList("Romi singh"));
	}
	
	public static void selectContact(String contactName) {
		String webTableXpath = "//a[@_name='"+contactName+"']//parent::td//preceding-sibling::td/input";
		driver.findElement(By.xpath(webTableXpath)).click();
	}
	
	public static String getCompanyName(String contactName) {
		String companyXpath = "//a[@_name='"+contactName+"']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(companyXpath)).getText();
	}
	
	public static List<String> getContactPhoneList(String contactName) {
		String contactList = "//a[@_name='"+contactName+"']//parent::td//following-sibling::td/span[@context='phone']";
		List<WebElement> phoneList = driver.findElements(By.xpath(contactList));
		List<String> phoneValList = new ArrayList<String>();
		for(WebElement e : phoneList) {
			String text = e.getText();
			phoneValList.add(text);
		}
		
		return phoneValList;
		
	}

}
