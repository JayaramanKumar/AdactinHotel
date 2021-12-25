package org.pomspace;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class BookingConfirmation extends LibGlobal {

	@FindBy(id = "order_no")
	private static WebElement orderId;

	public BookingConfirmation() {

		PageFactory.initElements(driver(), this);
	}

	public static String getOrderID() {

		BookingConfirmation bookConfirm = new BookingConfirmation();
		return getAttribute(orderId);
	}

	public void updateOrderID() throws IOException {

		updateData("Sheet1", 2, 0, getOrderID());

	}
}
