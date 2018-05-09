package com.cpw.ews.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpw.ews.qa.base.TestBase;
import com.cpw.ews.qa.pages.Homepage;
import com.cpw.ews.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	TestUtil testUtil;
	Homepage homepage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setExtent()
	{
		setExtentReport();
		
		
	}
	
	@AfterTest
	public void endReport(){
		endExtentReport();
	}
	

	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		homepage = new Homepage();
		extentTest = extent.startTest("HomePageTest");
			
	}
	
	@Test(priority=1)
	public void accept_cookie_test()
	{
		
		homepage.acceptCookie();
	}
	
	@Test(priority=2)
	public void verify_homepage_tile_test()
	{
		homepage.acceptCookie();
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Compare Our Best Mobile Phone Deals | Carphone Warehouse123","Home Page title not matched");
	}
	
	@Test(priority=3)
	
	public void verify_navigation_to_pagG_page()
	{
		homepage.acceptCookie();
		homepage.click_On_PagG_MegaMenu();
		
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		return;
		
	}

}
