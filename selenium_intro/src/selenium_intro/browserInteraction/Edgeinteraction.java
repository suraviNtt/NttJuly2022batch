package selenium_intro.browserInteraction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edgeinteraction {

	public static void main(String[] args) {
//		String projectLocation = System.getProperty("user.dir");
//		System.out.println(projectLocation);
//		String chromedrivelocation = "/drivers/msedgedriver.exe";
//		System.out.println(chromedrivelocation);
//		String driverPath = projectLocation + chromedrivelocation;
//		System.out.println(driverPath);
//		System.setProperty("webdriver.edge.driver", driverPath);
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"/drivers/msedgedriver.exe" );
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.close();

	}
}
