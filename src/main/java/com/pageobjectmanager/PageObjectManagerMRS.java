package com.pageobjectmanager;

import com.base.Base_Class;
import com.property.FileReaderManagerMRS;

import pageobjectmodel.OpenMRSLogin;
import pageobjectmodel.OpenMRSRegister;

public class PageObjectManagerMRS extends Base_Class {
	private OpenMRSLogin loginPage;
	private OpenMRSRegister registerPage;
	private FileReaderManagerMRS fileReader;
	
		public FileReaderManagerMRS getFileReader() {
			if(fileReader==null) {
				fileReader=new FileReaderManagerMRS();
			}
			return fileReader;
		}
	
		public OpenMRSLogin getLoginPage() {
			if(loginPage == null) {
				loginPage=new OpenMRSLogin(driver);
			}
			return loginPage;
		}
		
		public OpenMRSRegister getRegisterPage() {
			if(registerPage == null) {
				registerPage=new OpenMRSRegister(driver);
			}
			return registerPage;
		}
		
		
		
		
		}

