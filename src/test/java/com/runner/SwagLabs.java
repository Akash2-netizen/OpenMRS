package com.runner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class SwagLabs extends Base_Class {
	
	

@Test(groups="login")
  private void browserLaunch() {
	launchBrowser("chrome");
}

  @Test(dependsOnMethods="browserLaunch",groups="login")
  private void urlLaunch() {
	  launchUrl("https://www.saucedemo.com/v1/index.html");  
  }
  
  @Test(dependsOnMethods="urlLaunch",groups="login")
  private void login() {

       driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();
	  String Currenturl=driver.getCurrentUrl();
	  Assert.assertEquals(Currenturl,"https://www.saucedemo.com/v1/inventory.html");
  }
  
  
@Test(dependsOnMethods="login",groups="order")
 private void searchProduct() {
	  driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
	  driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();
	  driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();
	driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
  }

@Test(dependsOnMethods="searchProduct",groups="order")
private void checkout() {
	 driver.findElement(By.id("first-name")).sendKeys("Mohan");
	 driver.findElement(By.id("last-name")).sendKeys("Mh2");
	 driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("600056");
	 driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
	 driver.findElement(By.xpath("//a[text()='FINISH']")).click();
	 terminateBrowser();
}



}
