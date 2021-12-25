package org.pomspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class BookHotel extends LibGlobal {

	public BookHotel() {
		PageFactory.initElements(driver(), this);

	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCardNumber;

	@FindBy(id = "cc_type")
	private WebElement ddnCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnCardExpiryMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnCardExpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNumber;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getDdnCardExpiryMonth() {
		return ddnCardExpiryMonth;
	}

	public WebElement getDdnCardExpiryYear() {
		return ddnCardExpiryYear;
	}

	public WebElement getTxtCvvNumber() {
		return txtCvvNumber;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void enterDetailss(String firstName, String lastName, String billingAddress) {

		type(getTxtFirstName(), firstName);

		type(getTxtLastName(), lastName);

		type(getTxtAddress(), billingAddress);
	}

	public void payment(String cardNo, String cardType, String cardExpMonth, String cardExpYear, String cardCvvNo) {

		type(getTxtCardNumber(), cardNo);
		selectoptionsByText(getDdnCardType(), cardType);
		selectoptionsByText(getDdnCardExpiryMonth(), cardExpMonth);
		selectoptionsByText(getDdnCardExpiryYear(), cardExpYear);
		type(getTxtCvvNumber(), cardCvvNo);
	}

	public void clickBookNow() {

		click(getBtnBookNow());
	}

	public String verifyBookConfirmation() throws InterruptedException {

		Thread.sleep(5000);

		WebElement findElementByXpath = findElementByXpath("//td[@class='login_title']");
		return getText(findElementByXpath);
	}
}
