package org.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart4PageTask extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		implicitlyWait(3000);

	}
	@BeforeMethod
	private void afterMethod() {
		System.out.println("Test Start"+new Date());
	}
	@Test(priority=1)
	private void test1() {
		System.out.println("Test 1");
		

	}
	@Test(priority=-1)
	private void test2() {
		System.out.println("Test 2");

	}
	@Test
	private void testA() {
		urlLaunch("https://www.flipkart.com/");
		
		WebElement closebtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closebtn.click();
		WebElement txtbox = driver.findElement(By.xpath("//input[@name='q']"));
		txtbox.sendKeys("samsung");
		WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		searchbtn.click();
		
		List<WebElement> sam = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
	
		for(int i=0;i<sam.size();i++) {
			WebElement sam1 = sam.get(i);
			String text = sam1.getText();
			System.out.println(text);
			
		}
		 WebElement nxtbtn = driver.findElement(By.xpath("//span[text()='Next']"));
		 if(nxtbtn.equals("NEXT")) {
			 click(nxtbtn);
		 }
		 

		
		ChromeOptions cp = new ChromeOptions();
		 cp.addArguments("--disable-notifications");
	
		
		
//		List l= new Vector();
//		for(int i=0;i<watches.size();i++) {
//			WebElement watch = watches.get(i);
//			String text = watch.getText();
//			System.out.println(text);
//			l.add(text);
//		}
//			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
//			List l1 = new ArrayList();
//			for(int i=0;i<prices.size();i++) {
//				WebElement price = prices.get(i);
//				String text = price.getText();
////				System.out.println(text);
//				l1.add(text);
//				
//				String rp1 = text.replace("₹", "");
//				String rp2 = rp1.replace(",", "");
//				int ip = Integer.parseInt(rp2);
//				System.out.println(ip);
//				l1.add(ip);
//			}
//			Map m  = new TreeMap();
//			for(int i=0;i<l.size();i++) {
//				m.put(l.size(), l1.size());
//				System.out.println(l.get(i)+"=="+l1.get(i));
//				
//			}
		

	}
	@Test(enabled=false)
	private void testB() {
		System.out.println("Test B");

	}
	@Test(invocationCount=5)
	private void testa() {
		

	}
	@AfterMethod
	private void AfterMethod() {
		System.out.println("End Time"+new Date());
	}
	@AfterClass
	private void afterClass() {
		

	}
	

}
