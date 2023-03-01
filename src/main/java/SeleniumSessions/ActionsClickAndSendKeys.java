package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
//		WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
//		WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));

		Actions action = new Actions(driver);
//		action.sendKeys(firstName, "Tom").build().perform();
//		action.sendKeys(lastName, "Peter").build().perform();

//		action.click(firstName).sendKeys("Noor").build().perform();
		
		
		By firstName = By.cssSelector("input#input-firstname");
		By lastName = By.cssSelector("input#input-lastname");
		By agreeCheckBox = By.xpath("//input[@type='checkbox']");
	
		doActionsSendKeys(firstName, "Noor");
		doActionsSendKeysOnActiveElements(lastName, "Mohammed");
		Thread.sleep(3000);
		doActionClick(agreeCheckBox);
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}
	
	public static void doActionsSendKeysOnActiveElements(By locator, String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	public static void doActionMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}

}
