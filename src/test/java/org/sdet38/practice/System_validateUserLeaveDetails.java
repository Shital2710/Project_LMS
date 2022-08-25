package org.sdet38.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.edu.lms.genericUtility.FileUtility;
import com.edu.lms.genericUtility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class System_validateUserLeaveDetails 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtlity wLib=new WebDriverUtlity();
		FileUtility fLib=new FileUtility();
		
		//Read the common data from propetirs file//
		String URL=fLib.getPropertyKeyValue("url");
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		
		//Launch the Browser//
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("incorrect browser");
		}
		
		//Login to the Application//
		wLib.waitForElementInDOM(driver);
		driver.get(URL);
		driver.findElement(By.id("form-username")).sendKeys(USERNAME);
		driver.findElement(By.id("form-password")).sendKeys(PASSWORD);		
		driver.findElement(By.name("btnSubmit")).click();	
		

		//Navigate to the Add Designation Page//
		WebElement listEmployee=driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[6]"));
		Actions act=new Actions(driver);
		act.moveToElement(listEmployee).perform();
		driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[10]")).click();
		
		//click on employee//
		driver.findElement(By.linkText("PRE0002")).click();
		
		//validate the page//
		String title =driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/h1")).getText();
		System.out.println(title);
		
		//Navigate to the Blood Group Page//
				WebElement bloodGroup=driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[6]"));
				act.moveToElement(bloodGroup).perform();
				driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[12]")).click();
		
	   //validate the page//
			
		String Title2=driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/h1")).getText();
		System.out.println(Title2);
		
		//logout from the application //
		WebElement logout=driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[6]"));
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[13]")).click();

		
		
		
		
		
		
		

	}

}
