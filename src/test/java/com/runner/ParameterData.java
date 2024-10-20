package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class ParameterData extends Base_Class {
@Test
@Parameters({"username","password"})
	 private void login(String username,String password) {
		 launchBrowser("chrome");
		 launchUrl("https://www.saucedemo.com/v1/index.html");
	      driver.findElement(By.id("user-name")).sendKeys(username);
		  driver.findElement(By.id("password")).sendKeys(password);
		  driver.findElement(By.id("login-button")).click();
		  
	  }
	
	
	
}
