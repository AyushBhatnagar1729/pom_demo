package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base
{
  
  //Object repository
  @FindBy(id = "email") WebElement Email;
  
  @FindBy(id = "pass") WebElement Password;
  
  @FindBy(xpath = "//label[@id = 'loginbutton']") WebElement LoginButton;
  
  @FindBy(xpath = "//a[text() = 'Forgotten account?']") WebElement ForgottenAccount;
  
  @FindBy() WebElement FacebookLogo;
  
  //Initialize all the objects
  public LoginPage()
  {
	  PageFactory.initElements(driver, this);
  }
  
  public String validateLoginPageTitle()
  {
		  return driver.getTitle();
  }
  
  
  public HomePage login()
  {
	  Email.sendKeys(prop.getProperty("Username"));
	  Password.sendKeys(prop.getProperty("Password"));
	  LoginButton.click();
	  
	  return new HomePage();
  }
  
 
}
