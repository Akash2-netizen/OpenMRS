package com.pageobjectmanager;

import com.base.Base_Class;
import com.property.FileReaderManager;

import pageobjectmodel.AdactinLoginPage;
import pageobjectmodel.BookHotel;
import pageobjectmodel.SearchHotelPage;

public class PageObjectManager extends Base_Class {
	private AdactinLoginPage loginPage;
	private FileReaderManager fileReader;
	private SearchHotelPage searchPage;
	private BookHotel hotel;
	
	public AdactinLoginPage getLoginPage() {
		if(loginPage==null) {
			loginPage=new AdactinLoginPage(driver);
		}
		return loginPage;
	}
	
	public SearchHotelPage getHotelPage() {
		if(searchPage==null) {
			searchPage=new SearchHotelPage(driver);
		}
		return searchPage;
	}
	
	public BookHotel getHotel(){
		if(hotel==null) {
			hotel=new BookHotel(driver);
		}
		return hotel;
	}
	
	
	
	
	public FileReaderManager getFileReader() {
		if(fileReader==null) {
			fileReader=new FileReaderManager();
		}
		return fileReader;
	}
}
