package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserUtil {

	public WebDriver driver;

	/**
	 * This method is used to launch the browser on the basis of the given browser name
	 * @param browser 
	 * @return this will return the driver
	 */ 
	public WebDriver launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noor Mohammed\\Downloads\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Noor Mohammed\\Downloads\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser : " + browser);
		}

		return driver;

	}
	/**
	 * This method is used to enter the url
	 * @param url
	 */
	public void enterUrl(String url) {
		if(url==null) {
			System.out.println("The entered URL is empty");
			return;
		}
		if(url.indexOf("http") == -1){
			System.out.println("http is missing in url");
			return;
		}
		driver.get(url);
	}

	/**
	 * This method is used to get tbe current page url
	 * @return
	 */
	public String getAppCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * This method will return the title of the page
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}


	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
