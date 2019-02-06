package com.qa.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.Pages.LoginPage;
import com.qa.base.Base;

public class LoginTest extends Base
{

	LoginPage loginPage;
	

	
	public LoginTest()
	{
		super();
	}
	
	@BeforeSuite
	public void browserInitialization()
	{
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browserInitiation();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginPageTitle() throws InterruptedException
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		Thread.sleep(3000);
	}
	
	/*@Test(priority = 2)
	public void validateLoginButton()
	{
		HomePage homePage = loginPage.login();
		String title = homePage.validateTitleOfHomePage();
		
		Assert.assertEquals(title, "Facebook");
		System.out.println("title of homepage is facebook");
	}*/
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
}
