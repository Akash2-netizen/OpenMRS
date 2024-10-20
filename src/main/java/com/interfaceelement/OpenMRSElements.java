package com.interfaceelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface OpenMRSElements {
	//Login page
	String username_id ="username";
	String password_xpath="//input[@placeholder='Enter your password']";
	String location_xpath="//li[text()='Inpatient Ward']";
	String login_xpath="//input[@class='btn confirm']";
	
	//Register Page
	String register_xpath="//a[text()[normalize-space()='Register a patient']]";
	String Patientname_name="givenName";
	String familyname_name="familyName";
	String next_id="next-button";
	String gender_xpath="//option[@value='M']";
	String birthday_name="birthdateDay";
	String birthmonth_name="birthdateMonth";
	String birthyear_id="birthdateYear-field";
	String address_id="address1";
	String phoneNo_name="phoneNumber";
	String relationtype_id="relationship_type";
	String relationname_xpath="//input[@placeholder='Person Name']";
	String confirm_xpath="//input[@value='Confirm']";
	
	
	
	/*driver.findElement(By.xpath("//a[text()[normalize-space()='Register a patient']]")).click();
	driver.findElement(By.name("givenName")).sendKeys("Mohan");
	driver.findElement(By.name("familyName")).sendKeys("Kumar");
	WebElement next=driver.findElement(By.id("next-button"));
	next.click();		
	driver.findElement(By.xpath("//option[@value='M']")).click();
	next.click();
	driver.findElement(By.name("birthdateDay")).sendKeys("21");
	WebElement element=driver.findElement(By.name("birthdateMonth"));
	dropDownObject(element);
	selectByValue(element,"10");
	driver.findElement(By.id("birthdateYear-field")).sendKeys("2007");
	next.click();
	driver.findElement(By.id("address1")).sendKeys("Chennai");
	next.click();
	driver.findElement(By.name("phoneNumber")).sendKeys("8724360654");
	next.click();
	next.click();
	driver.findElement(By.xpath("//input[@value='Confirm']")).click();*/
	
}
