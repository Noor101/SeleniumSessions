package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noor Mohammed\\Downloads\\chromedriver.exe");
		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); 
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
	