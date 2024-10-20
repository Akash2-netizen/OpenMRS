package com.runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Base_Class;

public class NewAdactin extends Base_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		launchUrl("https://adactinhotelapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement element1=driver.findElement(By.id("username"));
		passInput(element1,"Sriniakash");
		WebElement element2=driver.findElement(By.id("password"));
		passInput(element2,"Akash1999");
		WebElement element3=driver.findElement(By.id("login"));
		clickButton(element3);
		driver.findElement(By.id("location")).clear();
		//WebElement element4=driver.findElement(By.id("location"));
		//WebElement element4=driver.findElement(By.xpath("//select[@id='location']"));
		//selectByValue(element4,"London");
		//driver.findElement(By.xpath("//select[@id='location']"));
		driver.findElement(By.xpath("//select[@id='location']")).clear();
		WebElement source=driver.findElement(By.xpath("//select[@id='location']"));
		Select obj=new Select(source);
		obj.selectByIndex(2);
		
	}

}
