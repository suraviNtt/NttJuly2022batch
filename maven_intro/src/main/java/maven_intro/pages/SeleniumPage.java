package maven_intro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven_intro.handlers.CommonMethods;

public class SeleniumPage {

	CommonMethods commonMethods;
	
	@FindBy(xpath = "//span[normalize-space()='Downloads']")
	WebElement downloadLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Downloads']")
	WebElement downloadPageHeader;
	
	@FindBy(xpath = "//h4[normalize-space()='Firefox']")
	WebElement ffBrowserOption;
	
	public SeleniumPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void openDownloads() {
		commonMethods = new CommonMethods();
		commonMethods.clickOnElement(downloadLink);
	}
	
	public void verifyHeader() {
		commonMethods.elementVisibilityCheck(downloadPageHeader);
	}
	
	public void verifyFirefoxBorwserOption() {
		commonMethods.elementVisibilityCheck(ffBrowserOption);
	}
}
