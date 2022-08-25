package com.edu.lms.genericUtility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.edu.lms.objectRepository.HomePage;
import com.edu.lms.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	public static WebDriver driver;

	/* Object Creation for Lib */
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtlity wLib = new WebDriverUtlity();
	public FileUtility  fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();

	// Initialization//

	String URL;
	String USERNAME;
	String PASSWORD;
	String BROWSER;

	@BeforeSuite
	public void configBS() {
		System.out.println("========================connect to DB========================");
	}

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("=============Launch the Browser=======");
		
		BROWSER = fLib.getPropertyKeyValue("browser");

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

		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);

	}

	@BeforeMethod
	public void configBM() throws Throwable {
		/* common Data */
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");

		/* Navigate to app */
		driver.get(URL);

		/* step 1 : login */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		/* step 6 : logout */
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}
