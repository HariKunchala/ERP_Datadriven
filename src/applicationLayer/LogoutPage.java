package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
@FindBy(xpath ="(//a[starts-with(text(),' Logout')])[2]")
WebElement logoutclick;
public void adminLogout()
{
	logoutclick.click();
}
}
