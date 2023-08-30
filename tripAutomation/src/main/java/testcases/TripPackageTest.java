package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.TripPackageFunctions;
import utilities.AccessProperties;
import utilities.DriverSetup;

public class TripPackageTest {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		String browser=AccessProperties.getBrowser();
		String url=AccessProperties.getUrl();
	    DriverSetup d=new DriverSetup();


	    System.out.println("Select Browser Name \n1.chrome\n2.Firefox");
        WebDriver driver=d.openBrowser(browser);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
		driver.navigate().to(url); //to open the website
		driver.manage().window().maximize();
		//Navigate to home page of the application and click “Offers�? link.
				driver.findElement(By.xpath("//*[@id=\"themeSnipe\"]/div/div/div[4]/div[2]/div/ul/li[3]/a")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		TripPackageFunctions tpf = new TripPackageFunctions();
		
		tpf.validateBrowser(driver);
		tpf.validateLogo(driver);
		tpf.Display(driver);
		tpf.takeScreenshot(driver);
		tpf.closeBrowser(driver);
	}}
		
		
	