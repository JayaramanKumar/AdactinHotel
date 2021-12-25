package org.pomspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class SearchHotel extends LibGlobal {

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement roomNos;

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	@FindBy(id = "adult_room")
	private WebElement adultRoom;

	@FindBy(id = "child_room")
	private WebElement childRoom;

	@FindBy(id = "Submit")
	private WebElement search;

	public SearchHotel() {

		PageFactory.initElements(driver(), this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getSearch() {
		return search;
	}

	public void searchHotel(String location, String hotels, String roomTYpe, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {

		selectoptionsByText(getLocation(), location);

		selectoptionsByText(getHotels(), hotels);
		selectoptionsByText(getRoomType(), roomTYpe);

		selectoptionsByText(getRoomNos(), noOfRooms);

		getCheckInDate().clear();
		type(getCheckInDate(), checkInDate);

		getCheckOutDate().clear();
		type(getCheckOutDate(), checkOutDate);

		selectoptionsByText(getAdultRoom(), adultsPerRoom);
		selectoptionsByText(getChildRoom(), childrenPerRoom);
		click(getSearch());

	}
	
	public void searchHotel(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {

		selectoptionsByText(getLocation(), location);
		selectoptionsByText(getRoomNos(), noOfRooms);
		getCheckInDate().clear();
		type(getCheckInDate(), checkInDate);
		getCheckOutDate().clear();
		type(getCheckOutDate(), checkOutDate);
		selectoptionsByText(getAdultRoom(), adultsPerRoom);
		click(getSearch());

	}
	
	
	public void clickSearchHotel(){
		click(getSearch());
	}
	
	public String actualResultSelectHotel() {
		
		WebElement findElementByXpath = findElementByXpath("//td[@class='login_title']");
		return getText(findElementByXpath);
	}
	
	public String actualErrLocationmsg() {
		WebElement findElementById = findElementById("location_span");
		return findElementById.getText();
		
	}
	
	public String actualErrCheckInError() {
		WebElement findElementById = findElementById("checkin_span");
		return findElementById.getText();
	}
	
	public String actualErrCheckOutError() {
		
		WebElement findElementById = findElementById("checkout_span");
		return findElementById.getText();
	}
	
}
