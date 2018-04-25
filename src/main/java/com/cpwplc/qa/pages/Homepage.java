package com.cpwplc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpwplc.qa.base.TestBase;

public class Homepage extends TestBase
{

//========================Home Page Object Repository===============================
	
	@FindBy(xpath = "//*[@id=\"cookieagree\"]")
	WebElement cookie;
	
	@FindBy(xpath =("//*[@id=\"Search_nav\"]/div[1]/div[2]/div/ul/li[1]/a"))
	WebElement shopclick;


//=========================Initializing the Page Objects===========================
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}

//============================Home Page Methods====================================
	
	public void AcceptCookie()
	{
		cookie.click();
	}
	
	public void shop_menu()
	{
		shopclick.click();
	}
}