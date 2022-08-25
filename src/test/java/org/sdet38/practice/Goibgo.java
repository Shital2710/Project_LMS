package org.sdet38.practice;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.edu.lms.genericUtility.Iconstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibgo {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Iconstants.Implicitly_TINEOUT, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//span[text()='From']")).click();
	  
	    driver.findElement(By.xpath("//span[text()='From']/../p[text()='Enter city or airport']")).sendKeys("pune");
	
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='September 2022']/../..//div/p[@class='fsw__date']")).click();
	}

}
