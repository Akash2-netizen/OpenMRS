package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.OpenMRSElements;
import com.property.FileReaderManager;
import com.property.FileReaderManagerMRS;

public class OpenMRSLogin extends Base_Class implements OpenMRSElements {

	@FindBy(id=username_id)
	private WebElement username;
	
	@FindBy(xpath=password_xpath)
	private WebElement password;
	
	@FindBy(xpath=location_xpath)
	private WebElement location;
	
	@FindBy(xpath=login_xpath)
	private WebElement login;
	
	
	
	public OpenMRSLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void validLogin() throws Throwable{
		implicitWait(10);
		FileReaderManagerMRS data= new FileReaderManagerMRS();
		launchUrl(data.getDataProperty("url"));
		passInput(username,data.getDataProperty("loginusername"));
		passInput(password,data.getDataProperty("loginpassword"));
		clickButton(location);
		clickButton(login);
		String page=driver.getTitle();
		boolean kone=validation(data.getDataProperty("title"),page);
		if(kone) {
			System.out.println("Home Page is Verified");
		}else {
			System.out.println("Home Page is UnVerified");
		}
		
	}
	
	
}
