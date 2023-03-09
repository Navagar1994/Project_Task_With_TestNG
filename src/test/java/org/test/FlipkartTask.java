package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlipkartTask extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		implicitlyWait(30);

	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Start Time"+new Date());
		System.out.println("Before Method");
		
	}
	@Test
	private void testB() throws InterruptedException {
		urlLaunch("https://www.flipkart.com/");
		SoftAssert s = new SoftAssert();
		s.assertTrue(getCurrentUrl().contains("flipkart"), "Verified");
		
		WebElement closebtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closebtn.click();
		
		
		WebElement txtbox = driver.findElement(By.xpath("//input[contains(@title,'for')]"));
		txtbox.sendKeys("vivo mobiles ");
		
		
		WebElement searchbtn = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		searchbtn.click();
		Thread.sleep(2000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List l = new LinkedList();
		for(int i=0;i<products.size();i++) {
			WebElement product = products.get(i);
			String text = product.getText();
			System.out.println(text);
			l.add(text);
		}
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List <Integer> l1 = new ArrayList();
		for(int i=0;i<prices.size();i++) {
			WebElement price = prices.get(i);
			String text = price.getText();
//			System.out.println(text);
			
			if(text.contains("₹")) {
				String rp = text.replace("₹","");
				if(text.contains(",")) {
					String rp1 = rp.replace(",", "");
					int rp2 = Integer.parseInt(rp1);
					System.out.println(rp2);
					l1.add(rp2);

				}   
			}
		}
		Collections.sort(l1);
		System.out.println(l1);
		
		Integer max = Collections.max(l1);
		System.out.println(max);
		
		Integer min = Collections.min(l1);
		System.out.println(min);
		
		Collections.reverse(l1);
		System.out.println(l1);
		
		Map m = new  TreeMap();
		
		for(int i=0;i<l1.size();i++) {
			m.put(l.size(), l1.size());
			System.out.println(l.get(i)+"=="+l1.get(i));
		}
		
		WebElement product1 = driver.findElement(By.xpath("(//div[contains(text(),'Y16')])[1]"));
		String text = product1.getText();
		System.out.println(text);
		product1.click();
		Thread.sleep(2000);
		
		switchToWindows(1);   
		
		WebElement product2 = driver.findElement(By.xpath("//span[contains(text(),'Y16')]"));
		String text2 = product2.getText();
		System.out.println(text2);
		

	
		
	 	if(text.equals("vivo Y16 (Drizzling Gold, 32 GB)  (3 GB RAM)")){
			close();
		}
		else {
			System.out.println("False");
		}
			   
		
		System.out.println("Test B");
	}
	@Test
	private void testA() {
		System.out.println("Test A");

	}
	@Test
	private void test1() {
		System.out.println("Test 1");

	}
	@Test
	private void test2() {
		System.out.println("Test 2");

	} 
	@Test
	private void testa() {
		System.out.println("Test a");

	}
	@Test
	private void testb() {
		System.out.println("Test b");

	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("End Time"+new Date());
		System.out.println("After Method");
	}
	@AfterClass
	private void afterClass() {
		System.out.println("After Class");

	}

}
