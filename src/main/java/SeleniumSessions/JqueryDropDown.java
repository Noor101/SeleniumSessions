package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");


		driver.findElement(By.xpath("(//button[@class='comboTreeArrowBtn'])[1]")).click();

		//		List<WebElement> choicesList = driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//ul/li/span[@class='comboTreeItemTitle']  "));
		//		for(WebElement e : choicesList) {
		//			String text = e.getText();
		//			if(text.equals("choice 1")) {
		//				e.click();
		//				break;
		//			}
		//		}

		By choices = By.xpath("//div[@class='comboTreeDropDownContainer']//ul/li/span[@class='comboTreeItemTitle']") ;
		//tc-01 - Single select
		//SelectChoice(choices, "choice 2");

		//tc-02 Multiselect
		SelectChoice(choices, "choice 2 2" , "choice 4", "choice 6 2 1");

		//tc-03 All

		//SelectChoice(choices, "all");





	}

	public static void SelectChoice(By locator , String... value) {
		List<WebElement> choicesList = driver.findElements((locator));
		if(!value[0].equals("all")) {


			for(WebElement e : choicesList) {
				String text = e.getText();
				for(int i=0;i<value.length;i++) {
					if(text.equals(value[i])) {
						e.click();
					}
				}
			}
		}
		else {
			//all selection logic
			try {
				for(WebElement e: choicesList) {
					e.click();
				}
			}
			catch(ElementNotInteractableException e) {
				System.out.println("all choices are over");
			}


		}
	}

}
