package com.cpw.ews.qa.rnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static WebDriver driver;
	public static void main(String[] args)
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Tools\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		*/
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Tools\\geckodriver.exe");	
		driver = new FirefoxDriver(); 
		
		driver.get("https://www.carphonewarehouse.com/mobiles/pay-monthly.html");
		driver.findElement(By.xpath("//*[@id=\"cookieagree\"]")).click();
		String mytest = driver.findElement(By.xpath("//div[@ng-if='totalResults >0']/span")).getText();
		System.out.println(mytest);
		
		//li[@class='dropdown mega-dropdown' and @data-overlay-id='0']
		//driver.findElement(By.xpath("//li[@class='dropdown mega-dropdown' and @data-overlay-id='0']")).click();
		//driver.findElement(By.xpath("//*[@id=\"Search_nav\"]/div[1]/div[2]/div/ul/li[1]/a")).click();
		//driver.findElement(By.xpath("//div[@class='mega-navigation__container open']//a[contains(@href, '/mobiles/pay-as-you-go.html')]")).click();
		
		//working code PAYM
		//driver.findElement(By.xpath("//div[@class='mega-navigation__container open' ]//ul[@id ='linkclicked']//a[@href='/mobiles/pay-monthly.html']")).click();
		
		//working code SIMfree
		//driver.findElement(By.xpath("//div[@class='mega-navigation__container open' ]//ul[@id ='linkclicked']//a[@href='/mobiles/sim-free.html']")).click();
		
		//working code SIMfree
		//.findElement(By.xpath("//div[@class='mega-navigation__container open' ]//ul[@id ='linkclicked']//a[@href='/sim-only.html']")).click();
		
		
		//driver.findElement(By.xpath("div[@class='mega-nav-tab mega-nav-tab-0 open' ]//following::a[@href='/mobiles/pay-monthly.html']")).click();
		
		//div[@class='mega-nav-tab mega-nav-tab-0 open' ]//following::a[@href='/mobiles/pay-monthly.html']
		
		
	}

}
