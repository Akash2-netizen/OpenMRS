package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
public abstract class Base_Class {
	public static WebDriver driver;
	public static ExtentReports extentReports;
	

	//1.Launch Browser
	protected static WebDriver launchBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING LAUNCHING BROWSER");
		}
		driver.manage().window().maximize();
		return driver;

}
	//2.get url
	protected static WebDriver launchUrl(String url) {
		
		try {
			driver.get(url);
			return driver;
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING LAUNCHING URL");
		}
		return driver;
	}
	
	//3.Close
	protected static void closeBrowser() {
			try {
				driver.close();
			} catch (Exception e) {
				Assert.fail("Error: OCCUR DURING CLOSING BROWSER");
			}
		}

	//4.Quit
	protected static void terminateBrowser() {
			try {
				driver.quit();
			} catch (Exception e) {
				
				Assert.fail("Error: OCCUR DURING TERMINATION OF BROWSER");
			}
		}
	
	//5.Navigate
	protected static void navigatePage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING NAVIGATE PAGE");
		}
	}
	
   //6.Navigate-forward
	protected static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING NAVIGATE FORWARD PAGE");
		}
	}
	
	//7.Navigate-backward
		protected static void navigateBackward() {
			try {
				driver.navigate().back();
			} catch (Exception e) {
				Assert.fail("Error: OCCUR DURING NAVIGATE BACKWARD PAGE");
			}
		}
		
	//8.Navigate-refresh
		protected static void navigateRefresh() {
			try {
				driver.navigate().refresh();
			} catch (Exception e) {
				Assert.fail("Error: OCCUR DURING NAVIGATE REFRESH PAGE");
			}
		}
		
	//9.send keys
	protected static void passInput(WebElement element, String input) {
			try {
				element.sendKeys(input,Keys.ENTER);
			} catch (Exception e) {
				Assert.fail("Error: OCCUR DURING PASSING INPUT");
			}
		}
	
	//10.click
    protected  static void clickButton(WebElement element) {
			try {
				element.click();
			} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING CLICKING ELEMENT");
			}
		}
    
    //Select
    protected static Select dropDownObject(WebElement element){
    	Select select=new Select(element);
    	return select;
    }
    
   //11.select by value
  	protected static void selectByValue(WebElement element, String value) {
  		
  			dropDownObject(element).selectByValue(value);
		
			}

   // 12.select by index
  	protected static void selectByIndex(WebElement element, int index) {
  		
			dropDownObject(element).selectByIndex(index);
		
  	}

   //13.select by visible text
  	protected static void selectByVisibletext(WebElement element, String text) {
		
			dropDownObject(element).selectByVisibleText(text);
		
	}
	
   //13.screen shot
  	protected static void getScreenshot(String valueby_png) throws Exception {
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        
	        try {
	        	File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

	            // Define the destination where the screenshot will be saved
	            File destFile = new File(valueby_png);

	            // Use FileUtils to copy the screenshot to the desired location
	            FileUtils.copyFile(srcFile, destFile);
	        } catch (IOException e) {
	        	Assert.fail("Problem occured due to not properly drop down select through the value");
	        }
	        
	        Thread.sleep(1000);

		} 
  	
   //14.scroll down and up
       protected static void scroll(String suv, WebElement element) {
  		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(suv, element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  	}
       
     //15.Alert accept
   	protected static void alertaccept() {
   		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

   //16.Alert dismiss
   	protected static void alertdismiss() {
   		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

   //17.Alert input
   	protected static void alertinput(WebElement element, String input) {
   		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

   //18.getAlerttext
   	protected static void getalerttext() {
   		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
   	
  //19.get current url
  	protected static void getCurrentUrl() {
  		try {
			System.out.println("The Current URL is " +driver.getCurrentUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}

  //20.get title
  	protected static void getTitle() {
  		try {
			driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
  	}

  //21.get text
  	protected static void getText(WebElement element) {
  		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
  	}

  	protected static Actions actionsObj() {
  		Actions as = new Actions(driver);
  		return as;
  	}

  //22.Actions drag&drop
  	protected static void draganddrop(WebElement element, WebElement element1) {
  		try {
			actionsObj().dragAndDrop(element, element1).click().build().perform();
		} catch (Exception e) {
	     e.printStackTrace();
		}
  	}

  //23.Actions click
  	protected static void actionClick(WebElement element) {
  		try {
			actionsObj().click(element).perform();
		} catch (Exception e) {
		e.printStackTrace();
		}
  	}

  //24.Actions move to element
  	protected static void movetoelement(WebElement element) {
  		try {
			actionsObj().moveToElement(element).perform();
		} catch (Exception e) {
		e.printStackTrace();
		}
  	}

  //25.Actions context click
  	protected static void contextclick(WebElement element) {
  		try {
			actionsObj().contextClick(element).perform();
		} catch (Exception e) {
		e.printStackTrace();
		}
  	}

  //26.Actions Double click
  	protected static void doubleclick(WebElement element) {
  		try {
			actionsObj().doubleClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
  	}

  
     
    //27.get window handle
 	public static void windowhandle() {
 		String id = driver.getWindowHandle();
 		System.out.println(id);
 	}
 	
 	
 	//28. get window handles
 	public static void windowhandles() {
 		Set<String> allid = driver.getWindowHandles();
 		System.out.println(allid);
 		for (String id : allid) {
 			String title = driver.switchTo().window(id).getTitle();
 			System.out.println(title);
 		}
 	}

     
    //29.Clear
     
 		protected static void clearValue(WebElement element) {
 			element.clear();
 		}
 		
 	//30.Implicit wait
 		public static void implicitWait(int sec) {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
 		}

 		
 	 //31.Explicit Wait
 	    protected WebElement explicitWait_for_visibility_of_element(int sec,String locator) {
 	    	Wait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));

 	        
 	       WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
 	       
 	       
 	      return element;

 		}
 	    
 	    
 	    
 	   //31.Get Excel Data
 	    protected static String getExcelData(int sheetIndexNo,int rowNo,int cellNo) throws Exception, Exception {
 	    	 File file=new File("C:\\Files\\Data_Driven.xlsx");
 	   	 Workbook book=new XSSFWorkbook(file);
 	   	 Sheet sheet=book.getSheetAt(sheetIndexNo);
 	   	 Row row=sheet.getRow(rowNo);
 	   	 Cell cell=row.getCell(cellNo);
 	   	 //DataFormatter is is used to convert in to string
 	   	 DataFormatter dataFormat=new DataFormatter();
 	   	 String data=dataFormat.formatCellValue(cell);
 	   	return data;
 	    } 
 	    //32.Extent Reports
 	   public static void extentReportStart(String location) {
 			extentReports = new ExtentReports();
 			File file = new File(location);
 			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
 			extentReports.attachReporter(sparkReporter);
 			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
 			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
 		}
 	 
 		public static void extentReportTearDown(String location) throws IOException {
 			extentReports.flush();
 			File file = new File(location);
 			Desktop.getDesktop().browse((file).toURI());
 		}
 	 
 		public String takeScreenshot() throws IOException {
 			TakesScreenshot screenshot = (TakesScreenshot) driver;
 			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
 			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
 			File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
 			FileUtils.copyFile(scrfile, destfile);
 			return destfile.getAbsolutePath();
 		}
 	 
 	    
 	    //33.Assertion
 		protected static boolean validation(String actual,String expected) {
 			try {
				Assert.assertEquals(actual,expected);
			} catch (Exception e) {
				Assert.fail("Error: OCCUR VALIDATION");
			}
			return true;
 		}


  	}

