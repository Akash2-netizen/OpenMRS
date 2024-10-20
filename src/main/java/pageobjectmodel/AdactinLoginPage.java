package pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.AdactinApplicationElements;
import com.property.FileReaderManager;

public class AdactinLoginPage extends Base_Class implements AdactinApplicationElements {
@FindBy(id=username_id)
private WebElement username;

@FindBy(id=password_id)
private WebElement password;

@FindBy(id=login_id)
private WebElement login;


//@FindBy(xpath=login_xpath)
//private WebElement login;
 
public AdactinLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void validUserNameAndValidPassword() throws Throwable{
	FileReaderManager data= new FileReaderManager();
	passInput(username,data.getDataProperty("loginusername"));
	passInput(password,data.getDataProperty("loginpassword"));
	clickButton(login);
	
}

//To get data from Excel sheet

/*public void validUserNameAndValidPasswordByExcel() throws Throwable{
	passInput(username,getExcelData(0,7,2));
	passInput(password,getExcelData(0,7,3));
	clickButton(login);

}*/

}
