package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//table[@id="customers"]/tbody/tr[2]/td[2]
		//table[@id="customers"]/tbody/tr[3]/td[2]
		
//		String beforeXpath_Comp = "//table[@id=\"customers\"]/tbody/tr[";
//		String afterXpath_Comp = "]/td[1]";
//		
//		int rowCount  = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
//		
//		for(int i=2; i<=rowCount; i++) {
//			String compXpath = beforeXpath_Comp+i+afterXpath_Comp;
//			String compText = driver.findElement(By.xpath(compXpath)).getText();
//			System.out.println(compText);
//		}
		
		By row = By.xpath("//table[@id='customers']/tbody/tr");
		By col = By.xpath("//table[@id='customers']/tbody/tr/th");
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[";
		
		printTable(row, col, beforeXpath, afterXpath);
	}
	
	public static void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath) {
		int rowCount = driver.findElements(rowLocator).size();
		int colCount = driver.findElements(colLocator).size();
		for(int row=2; row<=7; row++) {
			for(int col=1; col<=colCount; col++) {
				String xpath = beforeXpath+row+afterXpath+col+"]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.println(text);
				
			}
			System.out.println();
		}
	}
}
