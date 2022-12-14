package maven_intro.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import maven_intro.browserSetup.BrowserSetup;
import maven_intro.pages.GoogleSearchPage;
import maven_intro.pages.SeleniumPage;
import maven_intro.utils.PropertiesReader;

public class GoggleSearchTest {
	
	@Test(groups = "sanity")
	public void st() {
		PropertiesReader pr = new PropertiesReader();
		BrowserSetup browserSetup = new BrowserSetup();
		String browser = pr.getBrowserName();
		String url = pr.getAppURL();
		WebDriver driver = browserSetup.setBrowser(browser);
		driver.get(url);
		
		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		
		googleSearchPage.searchInText("Selenium");
		googleSearchPage.openFirstSearchResult();
		
		SeleniumPage seleniumPage = new SeleniumPage(driver);
		seleniumPage.openDownloads();
		
		browserSetup.quitBrowser(driver);
	}
	

}
