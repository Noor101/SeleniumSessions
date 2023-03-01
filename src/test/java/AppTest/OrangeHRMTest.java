package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{

	@Test(priority = 2)
	public void getCurrentURL() {
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("orangehrm"));
	}

	@Test(priority = 1)
	public void contactSalesTest() {
		//driver.get("https://www.orangehrm.com/");
		boolean flag = driver.findElement(By.linkText("Contact Sales")).isDisplayed();
		Assert.assertTrue(flag);
	}
}
