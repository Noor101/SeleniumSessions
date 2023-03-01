package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFireFox {

	public static void main(String[] args) {
		
	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Noor Mohammed\\Downloads\\geckodriver.exe");
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("The page title is :" +  title);
		
		if(title.equals("Google")) {
			System.out.println("PASS --- Correct title");
		}else {
			System.out.println("FAIL---- Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
	

}
