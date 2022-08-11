package maven_intro.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven_intro.browserSetup.BrowserSetup;
import maven_intro.handlers.CommonMethods;
import maven_intro.pages.GoogleSearchPage;
import maven_intro.pages.SeleniumPage;
import maven_intro.utils.PropertiesReader;

public class GSearchTest {

	private WebDriver driver;
	private BrowserSetup browserSetup;

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

	@Test(groups = "regression")
	public void testSearch() {

		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		CommonMethods commonMethods = new CommonMethods();
		googleSearchPage.searchInText("Selenium");
		googleSearchPage.openFirstSearchResult();

//		SeleniumPage seleniumPage = new SeleniumPage(driver);
//		seleniumPage.openDownloads();
		String expectedURL = "https://www.selenium.dev/";
		String expectedTitle = "Selenium";
		String actualURL = commonMethods.getCurrentURL(driver);
		String actualTitle = commonMethods.getPageTitle(driver);
		assertEquals(actualURL, expectedURL);
		assertEquals(actualTitle, expectedTitle);

	}

	@Test(groups = "regression")
	public void testsrach1() {
		System.out.println("testsearch1");
	}

	@Test(groups = "regression")
	public void testsrach2() {
		System.out.println("testsearch2");

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
