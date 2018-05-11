package com.cpw.ews.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
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
	Logger log = Logger.getLogger(HomePageTest.class);
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
		log.info("++++++++++ Starting test cases execution++++++++++");
		initialization();
		log.info("Browser initialized ");
		testUtil = new TestUtil();
		homepage = new Homepage();
		extentTest = extent.startTest("HomePageTest");
			
	}
	
	@Test(priority=1)
	public void accept_cookie_test()
	{
		log.info("++++++++++ Starting Accept Cookie Test ++++++++++");
		homepage.acceptCookie();
		log.info("++++++++++ End of Accept Cookie Test ++++++++++");
	}
	
	@Test(priority=2)
	public void verify_homepage_tile_test()
	{
		log.info("++++++++++ Starting Verify Home Page Test ++++++++++");
		homepage.acceptCookie();
		String homePageTitle = homepage.verifyHomePageTitle();
		log.info("Home Page Title is :- " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Compare Our Best Mobile Phone Deals | Carphone Warehouse123","Home Page title not matched");
		log.info("++++++++++ End of Verify Home Page Test ++++++++++");
	}
	
	@Test(priority=3)
	
	public void verify_navigation_to_pagG_page()
	{
		log.info("++++++++++ Starting Navigate to Pay as you go Page test  ++++++++++");
		homepage.acceptCookie();
		homepage.click_On_PagG_MegaMenu();
		log.info("++++++++++ Ending Navigate to Pay as you go Page test  ++++++++++");
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		return;
		
	}

}
