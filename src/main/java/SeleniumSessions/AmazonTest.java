package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.enterUrl("https://www.impacteers.club/");
		String title = br.getPageTitle();
		System.out.println(title);
		if(title.contains("Future")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Wrong title");
		}
		
		String url = br.getAppCurrentUrl();
		System.out.println(url);
		
		br.quitBrowser();
	}

}
