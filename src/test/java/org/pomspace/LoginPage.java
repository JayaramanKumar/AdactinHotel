package org.pomspace;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.libglobal.LibGlobal;

public class LoginPage extends LibGlobal {
	
	@FindBy(id = "username")
	private WebElement txtUserName;
	
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "login")
	private WebElement btnLogin;
	

	public WebElement getTxtUserName() {
		return txtUserName;
	}


	public WebElement getTxtPassword() {
		return txtPassword;
	}


	public WebElement getBtnLogin() {
		return btnLogin;
	}


	public LoginPage() {
		PageFactory.initElements(driver(), this);
	}
	
	
	public void login(String userName, String Password) {
		
		type(getTxtUserName(), userName);
		type(getTxtPassword(),Password);
		click(getBtnLogin());
	}
	
	
}
