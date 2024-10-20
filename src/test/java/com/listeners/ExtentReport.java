package com.listeners;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.base.Base_Class;

public class ExtentReport {

	
	
	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void extentTestReportStartup() throws IOException{
		Base_Class base=new Base_Class() {
			
		};
		base.extentReportStart(null);
	}
	
	public void extentTestReportEnd() throws IOException{
		Base_Class base=new Base_Class() {
			
		};
		base.extentReportTearDown(null);
	}
	
}
