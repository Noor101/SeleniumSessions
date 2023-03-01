package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		JavaScriptUtil util = new JavaScriptUtil(driver);
		String title = util.getTitleByJS();
		System.out.println(title);
		
		//util.generateAlert("This is NooR Mohammed");
		
//		String innerPageText = util.getPageInnerText();
//		System.out.println(innerPageText);
//		System.out.println(innerPageText.contains("Power up"));
		
		//util.refreshBrowserByJS();
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
//		util.drawBorder(loginBtn);
		
		
//		WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']"));
//		WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		
//		util.flash(email);
//		email.sendKeys("noor");
//		util.flash(pwd);
//		pwd.sendKeys("Noor123");
		
		
//		WebElement reg  = driver.findElement(By.linkText("Register"));
//		util.clickElementByJS(reg);
		
//		util.scrollPageDown();
//		Thread.sleep(3000);
//		util.scrollPageUp();
//		Thread.sleep(3000);
//		util.scrollPageDown("500");
//		
//		WebElement heading =  driver.findElement(By.xpath("//span[text()='Top selling products from small businesses']"));
//		util.scrollIntoView(heading);
//		System.out.println(heading.getText());
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']"));
		email.sendKeys("Noor@gmail.com");
		String val = email.getAttribute("value");
		System.out.println(val);
		
		
		
		
		
		

	}

}
