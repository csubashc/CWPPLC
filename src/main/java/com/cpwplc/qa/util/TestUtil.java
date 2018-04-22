package com.cpwplc.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cpwplc.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "D:\\Carphone\\cw\\src\\main\\java\\com\\cpwplc\\qa\\testdata\\CPWRedirects.xlsx";
	static Workbook book;
	static Sheet sheet;
	
// *******************Switch to frame****************************
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

// *************Load the Test Data Excel Sheet*******************
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" +
		sheet.getRow(0).getLastCellNum());
		/*
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
			{
		*/
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 2; k++)
			{
		data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k]);
		
			}
		}
		
		return data;
	}

//******* Take Screen Shot after the end of each Test ************
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public void closepopup() 
	{
		String expectedFrameID="edr_l_first";
	    List<WebElement> lst= driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of Iframes identified is "+lst.size());
	    int flag=0;
	    for(int i=0;i<lst.size();i++)
	    {
	        String actualFrameID=lst.get(i).getAttribute("id");
	        System.out.println(lst.get(i).getAttribute("id"));
	        if(expectedFrameID.equals(actualFrameID))
	        {
	            flag=1;
	            break;
	        }
	    }
		if(flag==1)
		{
			System.out.println("Popu up Found");
			driver.switchTo().frame("edr_l_first");
			driver.findElement(By.xpath("//*[@id='edr_layer_no']/img")).click();
			System.out.println("Pop up Closed");
		}
	}
	
			
}
