package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class MRS extends Base_Class{

	@Test
	private void Login(){
		launchBrowser("chrome");
		launchUrl("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[text()='Inpatient Ward']")).click();
		driver.findElement(By.xpath("//input[@class='btn confirm']")).click();
		driver.findElement(By.xpath("//a[text()[normalize-space()='Register a patient']]")).click();
		driver.findElement(By.name("givenName")).sendKeys("Mohan");
		driver.findElement(By.name("familyName")).sendKeys("Kumar");
		WebElement next=driver.findElement(By.id("next-button"));
		next.click();		
		driver.findElement(By.xpath("//option[@value='M']")).click();
		next.click();
		driver.findElement(By.name("birthdateDay")).sendKeys("21");
		WebElement element=driver.findElement(By.name("birthdateMonth"));
		dropDownObject(element);
		selectByValue(element,"4");
		driver.findElement(By.id("birthdateYear-field")).sendKeys("2007");
		next.click();
		driver.findElement(By.id("address1")).sendKeys("Chennai");
		next.click();
		driver.findElement(By.name("phoneNumber")).sendKeys("8724360654");
		next.click();
		next.click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();

		
		
	}
	
}
