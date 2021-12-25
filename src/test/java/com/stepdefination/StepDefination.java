package com.stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.pomspace.BookHotel;
import org.pomspace.CancelBooking;
import org.pomspace.LoginPage;
import org.pomspace.SearchHotel;
import org.pomspace.SelectHotel;

import com.libglobal.LibGlobal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination extends LibGlobal {

	private LoginPage login ;
	private CancelBooking cancelBooking;
	private SelectHotel selectHotel;
	private SearchHotel searchHotel;
	private BookHotel bookHotel;
	
	@Given("User is on the Adactin login page")
	public void userIsOnTheAdactinLoginPage() {
		getDriver();
		loadUrl("https://adactinhotelapp.com/");
	}

	@When("User should enter {string}, {string} and click login button")
	public void userShouldEnterAndClickLoginButton(String userName, String password) {

		login = new LoginPage();
		login.login(userName, password);
	}

	@When("User should search hotel with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and search hotel")
	public void searchHotel(String location, String hotels, String roomTYpe, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		searchHotel = new SearchHotel();
		searchHotel.searchHotel(location, hotels, roomTYpe, noOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrenPerRoom);

	}

	@When("User should select one of the hotel and click continue")
	public void selectHotel() {
		selectHotel = new SelectHotel();
		selectHotel.selectHotel();
	}

	@When("User should enter {string}, {string} and {string}")
	public void enterFieldsToBookHotel(String firstName, String lastName, String billingAddress) {

		if(bookHotel == null) {
			bookHotel = new BookHotel();
		}
		bookHotel.enterDetailss(firstName, lastName, billingAddress);

	}

	@When("User should make payment")
	public void userShouldMakePayment(io.cucumber.datatable.DataTable dataTable) {
		if(bookHotel == null) {
			bookHotel = new BookHotel();
		}
		
		List<Map<String, String>> cardDetails = dataTable.asMaps();
		Map<String, String> card = cardDetails.get(1);
		String cardNo = card.get("creditCardNo");
		String cardType = card.get("creditCardType");
		String cardExpMonth = card.get("expMonth");
		String cardExpYear = card.get("expYear");
		String cardCvv = card.get("cvvNo");
		bookHotel.payment(cardNo, cardType, cardExpMonth, cardExpYear, cardCvv);
		bookHotel.clickBookNow();
	}

	@Then("User should verify the booking confirmed page {string} and order ID;")
	public void verifyBookingConfirmed(String exceptedResult) throws InterruptedException {
		
		Assert.assertEquals("Verify Booking Confirmation", exceptedResult,bookHotel.verifyBookConfirmation());
	}

	@When("User should book hotel without entering any fields")
	public void bookHotelWithoutData() {
		if(bookHotel == null) {
			bookHotel = new BookHotel();
		}
		bookHotel.clickBookNow();
	}

	@Then("User should verify getting the error messages for every fields as {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void verifyErrorFieldsForBookHotel(String expFirstNameErrMsg, String expLastNameErrMsg,
			String expAddressErrMsg, String expCardNoErrMsg, String expCardTypeErrMsg, String expCardExpErrMsg,
			String expCvvErrMsg) {
		

	}

	@When("User should click Booked itenerary and cancel the same order Id")
	public void clickBookedIteneraryAndCancelSameOrderID() {

		cancelBooking = new CancelBooking();
		cancelBooking.cancelHotel();
	}

	@Then("User should verify the booking cancelled message as {string}")
	public void verifyMsgBookingCancelled(String expCancelledMsg) {

		Assert.assertEquals("Verifying Booking Cancelled Msg", expCancelledMsg, cancelBooking.actualResult());
	}

	@When("User should click Booked itenerary and cancel the existing order Id {string}.")
	public void clickBookedIteneraryAndCancelExistingOrderID(String orderID) {
		
		cancelBooking.cancelHotel(orderID);
	}

	@Then("User should verify navigate to {string} page")
	public void verifySelectPage(String expSelectHotelPage) {
		
		Assert.assertEquals("Verifying Select Hotel Text", expSelectHotelPage, searchHotel.actualResultSelectHotel());
	}

	@When("User should search hotel with mandatory fields only {string}, {string}, {string}, {string}, {string} and search hotel")
	public void searchHotelWithMandatoryFields(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom) {
		if(searchHotel == null) {
			searchHotel = new SearchHotel();
		}
		searchHotel.searchHotel(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@When("User should search hotel without entering data and search hotel")
	public void searchHotelWithoutFields() {
		if(searchHotel == null) {
			searchHotel = new SearchHotel();
		}
		searchHotel.clickSearchHotel();
	}

	@Then("User should verify getting the error message for without entering data as {string} under search hotel")
	public void verifyErrorMsgInSeachPage(String expLocationErrMsg) {
		
		Assert.assertEquals("Location Error Message", expLocationErrMsg,searchHotel.actualErrLocationmsg());
	}

	@Then("User should verify the error message for entered invalid dates  as {string} and {string}")
	public void verifyErrorMsgInvalidDates(String expCheckInErrMsg, String expCheckOutErrMsg) {
		
		Assert.assertEquals("Date Invalid Error", expCheckInErrMsg,searchHotel.actualErrCheckInError());
		Assert.assertEquals("Date Invalid Error", expCheckOutErrMsg, searchHotel.actualErrCheckOutError());
	}

}
