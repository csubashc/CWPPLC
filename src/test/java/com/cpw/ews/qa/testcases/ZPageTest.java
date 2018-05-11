package com.cpw.ews.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ZPageTest extends TestBase
{
	private static final Object ITestResult = null;
	TestUtil testUtil;
	Homepage homepage;
	
	
	public ZPageTest()
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
			
	}
	
	@Test(priority=1)
	public void accept_cookie_test()
	{
		extentTest = extent.startTest("HomePageTest");
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
	
	@SuppressWarnings("static-access")
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		return;
		
	}

}
