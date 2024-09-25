package applicationLayer;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SupplierPage {
WebDriver driver;
public SupplierPage(WebDriver driver)
{
	this.driver = driver;

}
// define repostiory for supplier page
@FindBy(xpath = "(//a[contains(text(),'Suppliers')])[2]" )
WebElement clickSupplier;
@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
WebElement clickAddIcon;
@FindBy(xpath = "//input[@id='x_Supplier_Number']")
WebElement SupplierNumber;
@FindBy(xpath = "//input[@id='x_Supplier_Name']")
WebElement SupplierName;
@FindBy(xpath = "//textarea[@id='x_Address']")
WebElement Address;
@FindBy(xpath = "//input[@id='x_City']")
WebElement City;
@FindBy(xpath = "//input[@id='x_Country']")
WebElement Country;
@FindBy(xpath = "//input[@id='x_Contact_Person']")
WebElement ContactPerson;
@FindBy(xpath = "//input[@id='x_Phone_Number']")
WebElement PhoneNumber;
@FindBy(xpath = "//input[@id='x__Email']")
WebElement Email;
@FindBy(xpath = "//input[@id='x_Mobile_Number']")
WebElement MobileNumber;
@FindBy(xpath = "//textarea[@id='x_Notes']")
WebElement Notes;
@FindBy(id = "btnAction")
WebElement clickAddButton;
@FindBy(xpath ="//button[normalize-space()='OK!']")
WebElement clickConfirmOkButton;
@FindBy(xpath = "(//button[text()='OK'])[6]")
WebElement clickAlertOkButton;
@FindBy(xpath = "(//span)[30]")
WebElement clicksearchpannel;
@FindBy(xpath = "//input[@id='psearch']")
WebElement clicksearchTextbox;
@FindBy(xpath ="//button[@id='btnsubmit']")
WebElement clicksearchbutton;
@FindBy(xpath = "//table[@class ='table ewTable']/tbody/tr[1]/td[6]/div/span/span")
WebElement webTable;
// method for supplier creation
public boolean addSupplier(String SupplierName, String  Address, String  City, String Country,String ContactPerson, String PhoneNumber, 
		       String Email,String MobileNumber, String Notes) throws Throwable
{
	Actions ac = new Actions(driver);
	ac.moveToElement(this.clickSupplier).click().perform();
	Thread.sleep(2000);
	ac.moveToElement(this.clickAddIcon).click().perform();
	Thread.sleep(3000);
	String Exp_Data = this.SupplierNumber.getAttribute("value");
	this.SupplierName.sendKeys(SupplierName);
	this.Address.sendKeys(Address);
	this.City.sendKeys(City);
	this.Country.sendKeys(Country);
	this.ContactPerson.sendKeys(ContactPerson);
	this.PhoneNumber.sendKeys(PhoneNumber);
	this.Email.sendKeys(Email);
	this.MobileNumber.sendKeys(MobileNumber);
	this.Notes.sendKeys(Notes);
	this.clickAddButton.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	this.clickConfirmOkButton.click();
	Thread.sleep(2000);
	this.clickAlertOkButton.click();
	Thread.sleep(2000);
	if(!this.clicksearchbutton.isDisplayed())
      this.clicksearchpannel.click();
      this.clicksearchTextbox.clear();
      this.clicksearchTextbox.sendKeys(Exp_Data);
      this.clicksearchbutton.click();
      Thread.sleep(3000);
      String Act_data = webTable.getText();
      if(Act_data.equals(Exp_Data))
      {
    	  Reporter.log("Add Supplier is Success:::"+Exp_Data+"   "+Act_data,true);
    	  return true;
     }
      else {
    	  Reporter.log("Add Supplier is  not Success:::"+Exp_Data+"   "+Act_data,true);
    	  return false;
      }
	}
	
}
