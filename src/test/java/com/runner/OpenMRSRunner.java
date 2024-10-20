package com.runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManagerMRS;


public class OpenMRSRunner extends Base_Class {
	
	PageObjectManagerMRS pageObjectManager=new PageObjectManagerMRS();

	@BeforeTest
	public void setup() throws Throwable{
		launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
		
	}
	
	
	
	@Test(priority=1)
	public void validLogin() throws Throwable {
       pageObjectManager.getLoginPage().validLogin();
	}
	
	@Test(priority=2)
	public void register() throws Throwable {
		 pageObjectManager.getRegisterPage().register();
	}
	
	
	
	@AfterTest
	public void terminate() throws InterruptedException {
		Thread.sleep(5000);
		terminateBrowser();
		
	}
	
	
}
