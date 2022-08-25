package org.sdet38.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.edu.lms.genericUtility.FileUtility;
import com.edu.lms.genericUtility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListDesignation {

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
		WebElement designation=driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[6]"));
		Actions act=new Actions(driver);
		act.moveToElement(designation).perform();
		driver.findElement(By.xpath(" //ul[@class='sidebar-nav']/li[8]")).click();
		
		//List of Designation for all department//
		WebElement search=driver.findElement(By.id("empDptName"));
		search.click();
		driver.findElement(By.xpath("//option[text()='Select All']")).click();
		search.sendKeys(Keys.ESCAPE);
		

	}

}
