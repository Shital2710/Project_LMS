package org.sdet38.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import com.edu.lms.genericUtility.BaseClass;
import com.edu.lms.objectRepository.AddDesignationPage;

public class AddDesignationTest extends BaseClass
{
	@Test(groups="regression")
	public void addDesignationTest() throws Throwable
	{
		AddDesignationPage  add=new AddDesignationPage(driver);
		add.addDesignation();
	}
	
	@Test(groups="regression")
	
	public void addDesignationNegativeTest1() throws IOException
	{
		AddDesignationPage  add=new AddDesignationPage(driver);
		add.addDesignationNegativeTest1();
		String expDesignation="Software Engineer";
		String actDesignation="123";
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File desFile=new File("./Screenshot/"+actDesignation+".png");
		
		//Assert.assertEquals(expDesignation, actDesignation);
		FileUtils.copyFile(srcFile, desFile);
		//System.out.println("Test passed");
	}
 @Test(groups="Smoke")
	public void addDesignationNegativeTest2() throws IOException
	{
		AddDesignationPage  add=new AddDesignationPage(driver);
		add.addDesignationNegativeTest2();
		String expDesignation="Software Engineer";
		String actDesignation="A123";
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File desFile=new File("./Screenshot/"+actDesignation+".png");
		
		//Assert.assertEquals(expDesignation, actDesignation);
		FileUtils.copyFile(srcFile, desFile);
		//System.out.println("Test passed");
	}
 @Test(groups="Smoke")
	public void validateAddDesignationTest()
	{
		AddDesignationPage  add=new AddDesignationPage(driver);
		add.validateAddDesignationTest();
	}
	
	
	
	
	
}



