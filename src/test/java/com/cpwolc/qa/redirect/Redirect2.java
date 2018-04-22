package com.cpwolc.qa.redirect;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cpwplc.qa.base.TestBase;
import com.cpwplc.qa.util.TestUtil;


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
