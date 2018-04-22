package com.cpwolc.qa.redirect;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpwplc.qa.base.TestBase;
import com.cpwplc.qa.util.TestUtil;


public class MyTrialTest1 extends TestBase
{
	
	TestUtil testUtil;
	String sheetName = "Test";
	
	public MyTrialTest1()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		testUtil = new TestUtil();
	}
	
	@DataProvider
	public Object[][] myTestTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="myTestTestData")
	public void testsheet()
	{
		
		System.out.println("Jesus is Great ");
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
