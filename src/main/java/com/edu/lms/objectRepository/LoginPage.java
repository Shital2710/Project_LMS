package com.edu.lms.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="form-username")
	private WebElement username;
	
	@FindBy(id="form-password")
	private WebElement password;
	
	@FindBy(name="btnSubmit")
	private WebElement loginBtn;

	public WebElement getUsername() 
	{
		return username;
	}

	public WebElement getPassword()
	{
		return password;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	public void LoginToApp(String Username,String Password)
	{
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
	}



}
