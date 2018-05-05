package com.cpwolc.qa.redirect;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Tools\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://www.carphonewarehouse.com/");
		driver.manage().window().maximize();
	
		driver.manage().deleteAllCookies();
		
	    String expectedFrameID="edr_l_first";
	    List<WebElement> lst= driver.findElements(By.tagName("iframe"));
	    System.out.println(lst.size());
	    int flag=0;
	    for(int i=0;i<lst.size();i++){
	        String actualFrameID=lst.get(i).getAttribute("id");
	        System.out.println(lst.get(i).getAttribute("id"));
	        if(expectedFrameID.equals(actualFrameID)){
	            flag=1;
	            break;
	        }
	    }
	if(flag==1)
	{
		
		System.out.println("JJJJJJJJJJJJJJJJJJJJJJJ");
		//driver.findElement(By.id("id_1523291696240_0")).click();
		driver.switchTo().frame("edr_l_first");
		driver.findElement(By.xpath("//*[@id='edr_layer_no']/img")).click();
	//WebElement Linktest = driver.findElement(By.tagName("a"));
	//System.out.println(Linktest);
		
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		

	
	}
		
	}
	
}
		