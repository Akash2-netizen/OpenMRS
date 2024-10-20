package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class AdactinRunner extends Base_Class {
	public static void main(String[] args) throws Throwable{
		
	
PageObjectManager pageObjectManage=new PageObjectManager();

launchBrowser(pageObjectManage.getFileReader().getDataProperty("browser"));
launchUrl(pageObjectManage.getFileReader().getDataProperty("url"));
pageObjectManage.getLoginPage().validUserNameAndValidPassword();
pageObjectManage.getHotelPage().select_mandatory_inputs_and_Search();
pageObjectManage.getHotel().book_hotel();


//To get Data From Excel Sheeet
/*launchBrowser(pageObjectManage.getExcelData(0,7,0));
launchUrl(pageObjectManage.getExcelData(0,7,1));
pageObjectManage.getLoginPage().validUserNameAndValidPasswordByExcel();*/







}
}