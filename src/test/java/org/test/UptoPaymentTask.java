package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UptoPaymentTask extends BaseClass{
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		implicitlyWait(2000);

	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Stert Time"+new Date());
	}
	@Test
	private void testY() {
		urlLaunch("https://www.etsy.com/");
		WebElement searchbox = driver.findElement(By.xpath("//input[contains(@id,'global')]"));
		sendKeys("jewell", searchbox);
		WebElement searchbtn = driver.findElement(By.xpath("(//span[contains(@class,'wt')])[7]"));
		click(searchbtn);
		WebElement jewell = driver.findElement(By.xpath("(//img[contains(@class,'wt')])[8]"));
		click(jewell);
		WebElement select = driver.findElement(By.xpath("(//select[contains(@class,'wt')])[1]"));
		selectByValue(select, "2794224297");
		
	}
	
	@Test
	private void testy() {
		

	}
	@Test
	private void testq() {
	
	}
	@Test
	private void testQ() {
		
	}
	@Test
	private void testA() {
	

	}
	@Test
	private void testB() {
		
	}
	@AfterMethod
	private void afterMethod() {
	    System.out.println("End Time"+new Date());
	}
	@AfterClass
	private void afterClass() {
		
	}
	

}
