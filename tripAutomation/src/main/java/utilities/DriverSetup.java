package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	

	private static WebDriver driver;
	 public  WebDriver openBrowser(String browser) throws InterruptedException, IOException {
		
		
		
		System.out.println(browser);
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Eclipse java programs/tripAutomation/ChromeBrowser/chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Eclipse java programs/tripAutomation/ChromeBrowser/chromedriver.exe");
			
			driver = new ChromeDriver();
		} else {
			System.out.println("Not a valid browser");
		}
		return driver;
		}

}