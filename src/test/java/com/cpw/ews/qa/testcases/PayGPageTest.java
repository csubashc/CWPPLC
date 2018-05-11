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
import com.cpw.ews.qa.pages.PayGPage;
import com.cpw.ews.qa.pages.PayMPage;
import com.cpw.ews.qa.util.TestUtil;

public class PayGPageTest extends TestBase {
	
	Logger log = Logger.getLogger(PayGPageTest.class);
	TestUtil testUtil;
	Homepage homepage;
	PayMPage paympage;
	PayGPage paygpage;
	
	public PayGPageTest()
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
		testUtil = new TestUtil();
		homepage = new Homepage();
		paygpage = new PayGPage();
		extentTest = extent.startTest("PayGPageTest");
			
	}
	
	@Test(priority=1)
	public void navigate_to_PagG_from_homepage_and_verify_pagetitle()
	{
		log.info("++++++++++ Starting Accept Cookie Test ++++++++++");
		homepage.acceptCookie();
		homepage.click_On_PagG_MegaMenu();
		String paygPageTitle = paygpage.verifyPayGTitle();
		log.info("Pay as you go Page Title is :- " + paygPageTitle);
		Assert.assertEquals(paygPageTitle, "Pay as you go mobiles | Carphone Warehouse","PAYG Page title not matched");
		log.info("++++++++++ End of Accept Cookie Test ++++++++++");
	}
	

	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		log.info("++++++++++ Ending test cases execution++++++++++");
		return;
		
	}
	
}
