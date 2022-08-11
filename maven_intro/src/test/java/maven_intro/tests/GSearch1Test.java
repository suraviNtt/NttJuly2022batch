package maven_intro.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_intro.browserSetup.BrowserSetup;
import maven_intro.pages.GoogleSearchPage;
import maven_intro.pages.SeleniumPage;
import maven_intro.utils.PropertiesReader;

public class GSearch1Test {
	
	private WebDriver driver ;
	private BrowserSetup browserSetup;
	private GoogleSearchPage googleSearchPage;
	private SeleniumPage seleniumPage;
	
	@BeforeTest
	public void bt() {
		System.out.println("B t");
	}
	
	@BeforeMethod
	public void setup() {
		PropertiesReader pr = new PropertiesReader();
		browserSetup = new BrowserSetup();
		String browser = pr.getBrowserName();
		String url = pr.getAppURL();
		driver = browserSetup.setBrowser(browser);
		driver.get(url);
	}

	@Test(priority = 1 , groups = "sanity")
	public void testSearch() {
		

		googleSearchPage = new GoogleSearchPage(driver);

		googleSearchPage.searchInText("Selenium");
		googleSearchPage.openFirstSearchResult();

		seleniumPage = new SeleniumPage(driver);
		seleniumPage.openDownloads();
		seleniumPage.verifyHeader();
		seleniumPage.verifyFirefoxBorwserOption();
		System.out.println("Search Success");

			}

	@Test(priority = -1 , groups = {"sanity", "regression"})
	public void testsrach1() {
		
		googleSearchPage = new GoogleSearchPage(driver);

		googleSearchPage.searchInText("Selenium Books");
		googleSearchPage.openFirstSearchResult();
		
		System.out.println("testsearch1 success");
	}

	@Test(priority = 0 , groups = "regression")
	public void testsrach2() {
		int i = 10/0;
		System.out.println("testsearch2" + i);

	}
	
	@AfterMethod
	public void teardown() {
		browserSetup.quitBrowser(driver);

	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("aftertest");
	}


}
