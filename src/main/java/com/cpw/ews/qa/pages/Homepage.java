package com.cpw.ews.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpw.ews.qa.base.TestBase;

public class Homepage extends TestBase
{

//========================Home Page Object Repository===============================
	
	@FindBy(xpath = "//*[@id=\"cookieagree\"]")
	WebElement cookie;
	
	@FindBy(xpath ="//li[@class='dropdown mega-dropdown' and @data-overlay-id='0']")
	WebElement shop;
	
	@FindBy(xpath ="//div[@class='mega-navigation__container open' ]//ul[@id ='linkclicked']//a[@href='/mobiles/pay-monthly.html']")
	WebElement payM;

	@FindBy(xpath ="//div[@class='mega-navigation__container open']//a[contains(@href, '/mobiles/pay-as-you-go.html')]")
	WebElement payG;
	
	@FindBy(xpath ="//div[@class='mega-navigation__container open' ]//ul[@id ='linkclicked']//a[@href='/mobiles/sim-free.html']")
	WebElement simFree;
	
//=========================Initializing the Page Objects===========================
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}

//============================Home Page Methods====================================
	
	public void acceptCookie()
	{
		cookie.click();
	}
	
	public PayGPage click_On_PagG_MegaMenu()
	{
		shop.click();
		payG.click();
		return new PayGPage();
	}
	
	public PayMPage click_On_PagM_MegaMenu()
	{
		shop.click();
		payM.click();
		return new PayMPage();
	}
	
	public simFree click_On_simFree_MegaMenu()
	{
		shop.click();
		payG.click();
		return new simFree();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
}