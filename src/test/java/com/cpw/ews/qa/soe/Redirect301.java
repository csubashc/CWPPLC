package com.cpwolc.qa.redirect;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Redirect301 {

	public static WebDriver driver = new FirefoxDriver();
			
			public static void main(String[] args) {
				try {
					  FileInputStream file = new FileInputStream(new File("C:\\soft\\testData.xls")); 				 
					  HSSFWorkbook workbook = new HSSFWorkbook(file);
					  HSSFSheet sheet = workbook.getSheet("data");
							for(int count = 1;count<=sheet.getLastRowNum();count++){
							HSSFRow row = sheet.getRow(count);
							System.out.println("Running test case " + row.getCell(0).toString());
							runTest(row.getCell(1).toString(),row.getCell(2).toString());
							System.out.println(driver.getTitle());
							Cell cell1 = row.createCell(3);
							Cell cell2 = row.createCell(4);
							cell1.setCellValue(driver.getCurrentUrl());
						    

						    
						    if (driver.getCurrentUrl().equals(row.getCell(2).toString())) {
						    	cell2.setCellValue("Pass");
						    	
						    } else {
						    	cell2.setCellValue("Fail");
						      } 
						    
													
						    file.close();
						    FileOutputStream outFile =new FileOutputStream(new File("C:\\soft\\testData.xls"));
						    workbook.write(outFile);
						    										    
						    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(scrFile, new File("c:\\soft\\" + row.getCell(0).toString() + ".png"));
						
					}
					
					 } catch (FileNotFoundException fnfe) {
					  fnfe.printStackTrace();
					 } catch (IOException ioe) {
					  ioe.printStackTrace();
					 }
				driver.quit();
			}
				public static void runTest(String purl, String eurl) {
				    
				
					driver.get(purl);

				 	System.out.println(driver.getCurrentUrl());

					
				    if (driver.getCurrentUrl().equals(eurl)) {
				        System.out.println("Redirect URL is  " + eurl + ", as expected");
				    } else {
				        System.out.println("Redirected URL was " + eurl + ", but was " + driver.getCurrentUrl()+ " instead");
				    }
	 
				}
				
}
