package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class DataProvider1 extends Base_Class {

	@Test(dataProvider="orange")
	private void orange(String username,String password) {
		launchBrowser("chrome");
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		implicitWait(10);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	  }
	@DataProvider(name="orange")
	public Object [][] dataset(){
          return new Object[][] {{"Admin","admin123"},{"Dean","123"},{"staff","241"}};
	
	}
}
