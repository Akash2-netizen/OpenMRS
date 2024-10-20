package pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.AdactinApplicationElements;

public class SearchHotelPage extends Base_Class implements AdactinApplicationElements {
	@FindBy(id=select_location_id)
	private WebElement select_location;
	
	@FindBy(id=select_hotels_id)
	private WebElement select_hotels;
	
	@FindBy(id=select_room_type_id)
	private WebElement select_roomType;

	
	@FindBy(id=select_adult_room_id)
	private WebElement select_adult_room;
	
	@FindBy(id=select_room_nos_id)
	private WebElement select_room_nos;
	
	@FindBy(id=select_child_room_id)
	private WebElement select_child_room;
	
	@FindBy(id=check_in_date_id)
	private WebElement check_in_date;
	
	@FindBy(id=check_out_date_id)
	private WebElement check_out_date;
	
	@FindBy(id=search_id)
	private WebElement search;
	
	@FindBy(id=Select_Hotel_id)
	private WebElement select_the_hotel;
	
	@FindBy(id=Select_hotel_continue_id)
	private WebElement Select_hotel_continue;
	
	public SearchHotelPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void select_mandatory_inputs_and_Search() throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		selectByIndex(select_location,3);
		selectByIndex(select_hotels,1);
		selectByIndex(select_roomType,2);
		selectByIndex(select_adult_room,1);
		selectByIndex(select_room_nos,1);
		selectByIndex(select_child_room,1);
		clearValue(check_in_date);
		clearValue(check_out_date);
		passInput(check_in_date,"05/10/2024");
		passInput(check_out_date,"08/10/2024");
		
		getScreenshot("screenshot.png");
		clickButton(select_the_hotel);
		clickButton(Select_hotel_continue);
	}

	
	
}
