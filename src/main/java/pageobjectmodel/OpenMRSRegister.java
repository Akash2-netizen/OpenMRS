package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.excelutility.ExcelUtility;
import com.interfaceelement.OpenMRSElements;

public class OpenMRSRegister extends Base_Class implements OpenMRSElements {

   @FindBy(xpath=register_xpath)
	private WebElement register;
	
	@FindBy(name=Patientname_name)
	private WebElement patientname;
	
	@FindBy(name=familyname_name)
	private WebElement familyname;
	
	@FindBy(id=next_id)
	private WebElement next;
	
	@FindBy(xpath=gender_xpath)
	private WebElement gender;
	
	@FindBy(name=birthday_name)
	private WebElement birthday;
	
	@FindBy(name=birthmonth_name)
	private WebElement birthmonth;
	
	@FindBy(id=birthyear_id)
	private WebElement birthyear;
	
	@FindBy(id=address_id)
	private WebElement address;
	
	@FindBy(name=phoneNo_name)
	private WebElement phoneNo;
	
	@FindBy(id=relationtype_id)
	private WebElement relationtype;
	
	@FindBy(xpath=relationname_xpath)
	private WebElement relationName;
	
	@FindBy(xpath=confirm_xpath)
	private WebElement confirm;
	
	
	public OpenMRSRegister(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void register()throws Throwable{
		implicitWait(10);
		clickButton(register);
		passInput(patientname,ExcelUtility.getCellValue("Registration","user","Patient_name"));
		passInput(familyname,ExcelUtility.getCellValue("Registration","user","Patient_Family_name"));
		clickButton(next);
		clickButton(gender);
		clickButton(next);
		passInput(birthday,ExcelUtility.getCellValue("Registration","user","Patient_birthDay"));
		dropDownObject(birthmonth);
		selectByValue(birthmonth,"10");
		passInput(birthyear,ExcelUtility.getCellValue("Registration","user","Patient_birth_year"));
		clickButton(next);
		passInput(address,ExcelUtility.getCellValue("Registration","user","Address_1"));
		clickButton(next);
		passInput(phoneNo,ExcelUtility.getCellValue("Registration","user","Phone_number"));
		clickButton(next);
		dropDownObject(relationtype);
		selectByIndex(relationtype,2);
		passInput(relationName,ExcelUtility.getCellValue("Registration","user","Relation_name"));
		clickButton(next);
		clickButton(confirm);
		
		
		
		
		
		
		
	}
	
	
}
