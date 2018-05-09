package com.cpw.ews.qa.soe;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpw.ews.qa.base.TestBase;
import com.cpw.ews.qa.util.TestUtil;


public class Redirect2 extends TestBase

{
	TestUtil testUtil;
	String sheetName = "Data";
	
	public Redirect2()
	{
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
	}
	
	@DataProvider
	public Object[][] getCPWRedirectURL()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCPWRedirectURL")
	public void redirect(String purl, String eurl)
	{
		
		
		System.out.println(purl);
		driver.get(purl);
		String aurl = driver.getCurrentUrl();
		
		System.out.println(aurl);
		System.out.println(eurl);
	 }
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
