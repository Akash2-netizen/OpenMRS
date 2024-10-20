package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.AdactinApplicationElements;
import com.property.FileReaderManager;

public class BookHotel extends Base_Class implements AdactinApplicationElements {
	@FindBy(id=first_Name_id)
	private WebElement first_Name;
	
	@FindBy(id=last_Name_id)
	private WebElement last_Name;
	
	@FindBy(id=billing_Address_id)
	private WebElement billing_Address;
	
	@FindBy(id=creditCardNo_id)
	private WebElement creditCardNo;
	
	@FindBy(id=cvv_id)
	private WebElement cvv;
	
	@FindBy(id=book_now_id)
	private WebElement book_now;
	
	@FindBy(id=cc_type_id)
	private WebElement cc_type;
	
	@FindBy(id=cc_exp_month_id)
	private WebElement cc_exp_month;
	
	@FindBy(id=cc_exp_year_id)
	private WebElement cc_exp_year;
	
	@FindBy(xpath=booking_confirm)
	private WebElement booking_element_visible;
	
	//Logout
	@FindBy(id=logout_id)
	private WebElement logout;
	
	public BookHotel(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void book_hotel() throws Throwable{
		FileReaderManager data=new FileReaderManager();
		passInput(first_Name,data.getDataProperty("FirstName"));
		passInput(last_Name,data.getDataProperty("LastName"));
		passInput(billing_Address,data.getDataProperty("BillingAddress"));
		passInput(creditCardNo,data.getDataProperty("CreditCardNumber"));
		passInput(cvv,data.getDataProperty("CVV"));
		selectByIndex(cc_type,2);
		selectByIndex(cc_exp_month,4);
		selectByIndex(cc_exp_year,15);
		
		clickButton(book_now);
		
		WebElement element_visible = explicitWait_for_visibility_of_element(10, booking_confirm);
		
		System.out.println(element_visible.getText());
		
		
		if(element_visible.getText().equals("Booking Confirmation")) {
			System.out.println("Element is present");
		}else {
			System.out.println("Element is not present");
		}
		
		
		
		clickButton(logout);
		Thread.sleep(1000);
		getScreenshot("Screenshot2.png");
		
	}

	//String first_Name_id = "first_name";
	//String last_Name_id = "last_name";
	//String billing_Address_id = "address";
	//String creditCardNo_id = "cc_num";
	//String cvv_id = "cc_cvv";
	//String book_now_id = "book_now";

	
}
