package org.pomspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class CancelBooking extends LibGlobal {

	private String orderID;

	@FindBy(xpath = "//a[text() = 'Booked Itinerary']")
	private WebElement bookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtsearchOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnsearchHotelID;

	private WebElement btncancelHotel;

	private WebElement actualResult;

	public CancelBooking() {

		this.orderID = BookingConfirmation.getOrderID();
		PageFactory.initElements(driver(), this);
	}

	public void cancelHotel() {

		type(txtsearchOrderId, orderID);
		click(btnsearchHotelID);
		btncancelHotel = driver().findElement(By.xpath("//input[@value ='Cancel " + this.orderID + "']"));
		click(btncancelHotel);
		acceptAlert();

	}
	public void cancelHotel(String orderID) {

		type(txtsearchOrderId, orderID);
		click(btnsearchHotelID);
		btncancelHotel = driver().findElement(By.xpath("//input[@value ='Cancel " + orderID + "']"));
		click(btncancelHotel);

		acceptAlert();

	}

	public String actualResult() {

		actualResult = driver().findElement(By.id("search_result_error"));

		return getText(actualResult);
	}
}
