package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/big-bash-league-2022-23-1324623/melbourne-stars-vs-sydney-sixers-31st-match-1324654/full-scorecard");
		System.out.println(getWicketTakerName("Marcus Stoinis"));
		System.out.println(getPlayerScoreCard("Marcus Stoinis"));
	}
	
	public static String getWicketTakerName(String playerName) {
		String xpath = "//a[@title ='"+playerName+"']/parent::td//following-sibling::td/span";
		 return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> getPlayerScoreCard(String playerName) {
		String xpath = "//a[@title ='"+playerName+"']/parent::td//following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(xpath));
		List<String> scoreValList = new ArrayList<String>();
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreValList.add(text);
		}
		
		return scoreValList;
		
		
		
		
	}

}
