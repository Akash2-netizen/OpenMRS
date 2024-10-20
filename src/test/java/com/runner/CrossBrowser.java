package com.runner;


import org.testng.annotations.Test;

import com.base.Base_Class;

public class CrossBrowser extends Base_Class{
//@Ignore-It will skip the method
	@Test(priority=1,invocationCount=2)
	private void chrome() {
		launchBrowser("chrome");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID :" +Thread.currentThread().getId());
		terminateBrowser();
		
	}
	
	@Test(priority = 2)
	private void edge() {
		launchBrowser("edge");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID :" +Thread.currentThread().getId());
		terminateBrowser();
		
	}
	
	
	
}
