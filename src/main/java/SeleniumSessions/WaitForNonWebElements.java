package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://classic.crmpro.com/index.html");

		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		if(waitForUrlToContain("contact.html", 6)) {
			System.out.println("pass");
		}
		
		String title = doGetTitleWithFraction("CRMPRO", 5);
		System.out.println(title);
		
	}

	public static Boolean waitForUrlToContain(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public static Boolean waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public static boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	
	public static boolean waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	public static String doGetTitleWithFraction(String titleFraction, int timeOut) {
		if(waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String doGetTitle(String title, int timeOut) {
		if(waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
}
