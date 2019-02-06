package com.qa.Pages;

import com.qa.base.Base;

public class HomePage extends Base
{

	public String validateTitleOfHomePage()
	{
		return driver.getTitle();
	}
	
}
