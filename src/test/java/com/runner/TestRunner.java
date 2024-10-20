package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.base.Base_Class;

public class TestRunner extends Base_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   launchBrowser("chrome");
   launchUrl("https://www.google.com/");
   WebElement element =driver.findElement(By.className("gLFyf"));
   passInput(element,"Birds");
   navigatePage("https://www.flipkart.com/");
   navigateBackward();
   navigateForward();
   navigateRefresh();
   getCurrentUrl();
   WebElement element1=driver.findElement(By.className("Pke_EE"));
   passInput(element1,"Gaming laptop");
   getTitle();
   WebElement element2=driver.findElement(By.className("KzDlHZ"));
   actionClick(element2);
   closeBrowser();
   terminateBrowser();  
   
	}

}
