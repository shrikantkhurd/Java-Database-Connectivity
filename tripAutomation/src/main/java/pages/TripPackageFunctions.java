package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TripPackageFunctions {
	static WebDriver driver;
	
	/*public void Offers() {
		
				//Navigate to home page of the application and click “Offers�? link.
				driver.findElement(By.xpath("//*[@id=\"themeSnipe\"]/div/div/div[4]/div[2]/div/ul/li[3]/a")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}*/
	public void validateBrowser(WebDriver driver) {
	//Add a check point to validate whether the browser title is "Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com".
	String title="Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com";
	if(title.equals(driver.getTitle())) {
		System.out.println("Title is verified");
		System.out.println("Test Cases are Passed \n");}
	
		else {
			System.out.println("Not verified the page title \n");
			System.out.println("Test cases are Failed \n");
		}
		}
		
		
		public void validateLogo(WebDriver driver) {
			String actuallogo ="Great Offers & Amazing Deals";
			
			String expectedlogo=driver.findElement(By.xpath("//h2[@class='wfull bxs']")).getText();
		//Add a check point to validate whether the banner logo is "Great Offers & Amazing Deals"
		if(actuallogo.equals(expectedlogo)) {
			System.out.println("logo verified");
			System.out.println("Test Cases are Passed \n");
		}
		else {
			System.out.println("logo not verifed");
			System.out.println("Test Cases are Failed \n");
		}
	}
	
	
	
	public void Display(WebDriver driver) {
	System.out.println("Five Holiday Packages with it's price : \n");
	int i=1;
	ArrayList<String> elements=getPackages(driver);
	for (String values  : elements) {
		System.out.println((i++)+"."+values+"\n");
	}
	}


//Capture the screen shot of the browser window.

public static void takeScreenshot(WebDriver driver) throws IOException
{
	
	try
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	TakesScreenshot scrShot =((TakesScreenshot)driver);

    //Call getScreenshotAs method to create image file

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            Date date = new Date(); 
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            String strDate= formatter.format(date);
            
            File DestFile=new File("./Screenshots/"+strDate+".png");

            //Copy file at destination

     
			FileUtils.copyFile(SrcFile, DestFile);
	System.out.println("Screenshot is taken successfully \n");
	}
	catch(Exception e) {
		System.out.println(e);
	}
}
//List the five holiday packages with its price.
public static ArrayList<String> getPackages(WebDriver driver)
{		
	driver.findElement(By.xpath("//*[@id=\"offer-box-shadow\"]/li[4]/a")).click();
	List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\"collapsibleSection\"]/section[1]/div[2]/div/section/div/div/ul/li[*]/a/span/span/span[1]"));
	ArrayList<String> list=new ArrayList();
	int cou=0;
	for (WebElement webElement : elements) {
		cou++;
		if(cou==6)
		{
			break;
		}
		else
		{
			list.add(webElement.getText());}
	}
	return list;
	
}


//Close the browser.
public static void closeBrowser(WebDriver driver) {
	driver.close();
}
}



