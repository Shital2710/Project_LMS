package com.edu.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.lms.genericUtility.ExcelUtility;

public class AddDesignationPage 
{
	public WebDriver driver;
	public AddDesignationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//ul[@class='sidebar-nav']/li[7]")
	private WebElement addDesignationLink;

	@FindBy(id="dptName")
	private WebElement departmentName;
	

	@FindBy(id="desiName")
	private WebElement designationName;
	
	@FindBy(name="btnSubmit")
	private WebElement addDesignationBtn;
	
	@FindBy(xpath="//ul[@class='sidebar-nav']/li[8]")
	private WebElement listDesignationLink;
	
	public WebElement getListDesignationLink()
	{
		return listDesignationLink;
	}
	
	public WebElement getAddDesignationLink() 
	{
		return addDesignationLink;
	}


	public WebElement getDepartmentName()
	{
		return departmentName;
	}

	public WebElement getDesignationName() 
	{
		return designationName;
	}
	
	public WebElement getAddDesignationBtn()
	{
		return addDesignationBtn;
	}
	public void addDesignation() throws Throwable
	{
		addDesignationLink.click();
		departmentName.sendKeys("KeyEvent.PAGEDOWN");
		designationName.sendKeys("Software Engineer");
		addDesignationBtn.click();	
		
	}
	public void addDesignationNegativeTest1()
	{
		addDesignationLink.click();
		departmentName.sendKeys("KeyEvent.PAGEDOWN");
		designationName.sendKeys("123");
		addDesignationBtn.click();
		
	}
	public void addDesignationNegativeTest2()
	{
		addDesignationLink.click();
		departmentName.sendKeys("KeyEvent.PAGEDOWN");
		designationName.sendKeys("A123");
		addDesignationBtn.click();	
	}
	public void validateAddDesignationTest()
	{
		addDesignationLink.click();
		departmentName.sendKeys("KeyEvent.PAGEDOWN");
		designationName.sendKeys("A123");
		addDesignationBtn.click();	
		listDesignationLink.click();	
		
	}
	
	
	
}
