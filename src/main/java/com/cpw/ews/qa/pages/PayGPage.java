
package com.cpw.ews.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpw.ews.qa.base.TestBase;

public class PayGPage extends TestBase
{

//========================Pay As you Go Page Object Repository===============================
	
		

//=========================Initializing the Page Objects===========================
	
	public PayGPage()
	{
		PageFactory.initElements(driver, this);
	}

//============================Pay as you GO Page Methods====================================
	

	
	public String verifyPayGTitle()
	{
		return driver.getTitle();
	}
}