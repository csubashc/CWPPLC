package com.cpwplc.qa.endtoend;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cpwplc.qa.base.TestBase;
import com.cpwplc.qa.pages.Homepage;
import com.cpwplc.qa.util.TestUtil;

public class HomePage extends TestBase
{
	TestUtil testUtil;
	Homepage homepage;
	
	public HomePage()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		//testUtil.closepopup();
		homepage = new Homepage();
		
		
	}
	


	@Test(priority=1)
	public void accept_cookie_test()
	{
		homepage.AcceptCookie();
		//testUtil.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority=2)
	public void navigate_to_mobile()
	{
		homepage.AcceptCookie();
		homepage.shop_menu();
		//testUtil.takeScreenshotAtEndOfTest();
	}
	
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void teardown() throws IOException
	{
		testUtil.takeScreenshotAtEndOfTest();
		//driver.quit();
	}
	
	
}
