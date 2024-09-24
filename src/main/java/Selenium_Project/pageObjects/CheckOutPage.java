package Selenium_Project.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Project.Utilities.Utilities;

public class CheckOutPage extends Utilities{
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[data-test='proceed-1']")
	WebElement ProceedToCheckOut;
	
	@FindBy(css="[data-test='proceed-2']")
	WebElement ProceedToCheckOut2;
	
	@FindBy(css="[data-test='proceed-3']")
	WebElement ProceedToCheckOut3;
	
	@FindBy(css="[formcontrolname='address']")
	WebElement Address;
	
	@FindBy(css="#city")
	WebElement City;
	
	@FindBy(css="input[placeholder='State *']")
	WebElement State;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(xpath="//input[@formcontrolname='postcode']")
	WebElement Zipcode;
	
	@FindBy(css="#payment-method")
	WebElement PaymentDropdown;
	
	@FindBy(css="[data-test='finish']")
	WebElement ConfirmButton;
	
	@FindBy(css=".help-block")
	WebElement ConfirmPayment;
	

	
	public void CheckOut1()
	{
		waitForTheVisibilityOfElement(ProceedToCheckOut);
		ProceedToCheckOut.click();
		
	}
	
	public void CheckOut2()
	{
		waitForTheVisibilityOfElement(ProceedToCheckOut2);
		ProceedToCheckOut2.click();	
	}
	
	public PaymentsPage BillingAddress() throws IOException
	{
		Address.sendKeys(GetValue("Address"));
		City.sendKeys(GetValue("City"));
		State.sendKeys(GetValue("State"));
		Country.sendKeys(GetValue("Country"));
		Zipcode.sendKeys(GetValue("Zipcode"));
		ProceedToCheckOut3.click();
		waitForTheVisibilityOfElement(PaymentDropdown);
		PaymentsPage payment=new PaymentsPage(driver);
		return payment;
	}
	
	
	
	

}
