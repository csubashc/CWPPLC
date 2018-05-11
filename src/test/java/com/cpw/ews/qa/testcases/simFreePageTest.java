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
import com.cpw.ews.qa.pages.PayGPage;
import com.cpw.ews.qa.pages.PayMPage;
import com.cpw.ews.qa.util.TestUtil;

public class simFreePageTest extends TestBase {
	TestUtil testUtil;
	Homepage homepage;
	PayMPage paympage;
	PayGPage paygpage;
	
	public simFreePageTest()
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
		paygpage = new PayGPage();
		extentTest = extent.startTest("PayGPageTest");
			
	}
	
	@Test(priority=1)
	public void navigate_to_PagG_from_homepage_and_verify_pagetitle()
	{
		
		homepage.acceptCookie();
		homepage.click_On_PagG_MegaMenu();
		String paygPageTitle = paygpage.verifyPayGTitle();
		Assert.assertEquals(paygPageTitle, "Pay as you go mobiles | Carphone Warehouse","PAYG Page title not matched");
	}
	

	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		TestBase.myTearDown(result);
		return;
		
	}
	
}
