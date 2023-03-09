package org.test;

import org.testng.annotations.Test;

public class BracersTask {
	
	@Test
	private void test1() {
		
		String  s ="(()){{}}[[]]";
		
		System.out.println(s);
		
		int l = s.length();
		System.out.println(l);
		
		if(s.contains("(())[[]]{{}}")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
		
		

	}

}
