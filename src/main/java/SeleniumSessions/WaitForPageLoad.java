package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoad {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://api.cogmento.com/register/?lang=en-GB");
		driver.findElement(By.partialLinkText("Log in here")).click();
		JavaScriptUtil util = new JavaScriptUtil(driver);
		util.waitForPageLoaded();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Noor@gmail.com");
	}

}
