package com.cpw.ews.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpw.ews.qa.base.TestBase;
import com.cpw.ews.qa.pages.Homepage;
import com.cpw.ews.qa.pages.PayMPage;
import com.cpw.ews.qa.util.TestUtil;

public class PayMPageTest extends TestBase {
	
	Logger log = Logger.getLogger(PayMPageTest.class);
	TestUtil testUtil;
	Homepage homepage;
	PayMPage paympage;

	
	public PayMPageTest()
	{
		super();
	}
//-----------------------------
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
		testUtil = new TestUtil();
		homepage = new Homepage();
		paympage = new PayMPage();
		extentTest = extent.startTest("PayMPageTest");
			
	}
	
	@Test(priority=1)
	public void navigate_to_PagM_from_homepage_and_verify_pagetitle()
	{
		
		homepage.acceptCookie();
		homepage.click_On_PagM_MegaMenu();
		String paymPageTitle = paympage.verifyPayMTitle();
		log.info("Pay Monthly Page Title is :- " + paymPageTitle);
		Assert.assertEquals(paymPageTitle, "Pay monthly mobiles | Carphone Warehouse","PAYM Page title not matched");
	}
	
	
	@Test(priority=2)
	public void Check_Devices_found()
	{
		homepage.acceptCookie();
		driver.get("https://www.carphonewarehouse.com/mobiles/pay-monthly.html");
		log.info(paympage.verifydevicefound());
		System.out.println(paympage.verifydevicefound());
	}
	

	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		log.info("++++++++++ Ending test cases execution++++++++++");
		return;
		
	}
	
}
