package org.pomspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class SelectHotel extends LibGlobal {

	@FindBy(id = "radiobutton_0")
	private WebElement rdBtnSelectHotel;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	public SelectHotel() {

		PageFactory.initElements(driver(), this);
	}

	public WebElement getRdBtnSelectHotel() {
		return rdBtnSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {

		click(getRdBtnSelectHotel());

		click(getBtnContinue());

	}
	
}
