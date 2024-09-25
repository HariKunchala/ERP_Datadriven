package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
// Define repository for login
	@FindBy(xpath = "//button[@id='btnreset']")
	WebElement ObjReset;
	@FindBy(id =  "username")
	WebElement ObjUser;
	@FindBy(name =  "password")
	WebElement Objpass;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjLogin;
	// Write method to perform action
	public void adminLogin(String user,String pass)
	{
		ObjReset.click();
		ObjUser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLogin.click();
	}
	
	
}
