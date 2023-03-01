package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {

	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "chrome";
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noor Mohammed\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Noor Mohammed\\Downloads\\geckodriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Safari")) {

			driver = new SafariDriver();

		} else {
			System.out.println("Please pass the correct browser : " + browser);
		}

		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("The page title is :" + title);

		if (title.equals("Google")) {
			System.out.println("PASS --- Correct title");
		} else {
			System.out.println("FAIL---- Incorrect title");
		}

		System.out.println(driver.getCurrentUrl());

		driver.quit();
	}

}
