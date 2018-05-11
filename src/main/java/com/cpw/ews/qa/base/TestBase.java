/*
*************************************************************************
Objective :
Author:
Comments :
*************************************************************************
*/

package com.cpw.ews.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.cpw.ews.qa.testcases.ZPageTest;
import com.cpw.ews.qa.util.TestUtil;
import com.cpw.ews.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase

{
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/cpw/ews/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Tools\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Tools\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
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
	
	
	public void setExtentReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Subash PC");
		extent.addSystemInfo("User Name", "Subash");
		extent.addSystemInfo("Environment", "Testing");
		
	}
	
	public void endExtentReport()
	{
	
	extent.flush();
	extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestExecutionScreenshots/" + screenshotName + dateName	+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	public static void myTearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE){
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
		String screenshotPath = getScreenshot(driver, result.getName());
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
	}
		else if(result.getStatus()==ITestResult.SKIP)
	{
		extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
		else if(result.getStatus()==ITestResult.SUCCESS)
	{
		extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		String screenshotPath = getScreenshot(driver, result.getName());
		extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
	}
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
}
