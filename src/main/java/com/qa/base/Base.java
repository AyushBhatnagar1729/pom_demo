package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Util.Constants;

public class Base
{
	public static WebDriver driver;
	public static Properties prop;

	public Base()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Ayush Bhatnagar\\eclipse-workspace\\pom_demo\\src\\main\\java\\config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void browserInitiation()
	{
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
		    driver = new FirefoxDriver();
		    driver.get(prop.getProperty("URL"));
		}
	
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeout, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
	}
	
	

	
}
