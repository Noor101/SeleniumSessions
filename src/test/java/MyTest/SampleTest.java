package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void searchButtonText() {
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void urlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
