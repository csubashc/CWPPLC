package com.cpw.ews.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpw.ews.qa.base.TestBase;

public class PayMPage extends TestBase
{
//========================Pay Monthly Page Object Repository===============================
			
	@FindBy(xpath = "//div[@ng-if='totalResults >0']")
	WebElement totalresult;			

//=========================Initializing the Page Objects===========================
	public PayMPage()
	{
	PageFactory.initElements(driver, this);
	}

//============================Pay as you GO Page Methods====================================
	
//+++ Get Pay Monthly title+++
	public String verifyPayMTitle()
	{
		return driver.getTitle();
	}
//+++ Get Number of devices found+++
	public String verifydevicefound()
	{
		String rtr = totalresult.getText();
		return rtr;
	}	

}


