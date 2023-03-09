package org.test;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SuggestionListTaskFlipkartAndGoogle extends BaseClass {
	
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		implicitlyWait(20);

	}
	@BeforeMethod
	private void beforeMethhod() {
		System.out.println("Before Method"+new Date());
		

	}
	@Test
	private void testB() {
		urlLaunch("https://www.google.com/");
		SoftAssert s  =  new SoftAssert();
		s.assertTrue(getCurrentUrl().contains("flipkart"),"Verified");
		
		WebElement txtbox = driver.findElement(By.xpath("//input[contains(@data-ved,'CAQ')]"));
		txtbox.sendKeys("bmw");
		s.assertEquals(getAttribute(txtbox), "bmw","Verified");
		
		List<WebElement> bmws = driver.findElements(By.xpath("//input[@class='gLFyf']//following::div[11]"));
		for(WebElement x:bmws) {
			String text = x.getText();
			System.out.println(text);
			
		}
		

		
		System.out.println("Test B");

		
	}
	@Test(enabled=false)
	private void testb() {
		System.out.println("Test b");

	}
	@Test(priority=-1)
	private void testa() {
		System.out.println("Test a");

	}
	@Test(priority=1)
	private void testA() {
		System.out.println("Test A");

	}
	@Test(invocationCount=3)
	private void test2() {
		System.out.println("Test 2");

	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method"+new Date());
	}
	@AfterClass
	private void aftterClass() {
		

	}
	

}
