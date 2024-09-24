package Selenium_Project.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Project.Utilities.Utilities;

public class PaymentsPage extends Utilities{
	 WebDriver driver;

	public PaymentsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#payment-method")
	WebElement PaymentDropdown;
	
	@FindBy(css="[data-test='finish']")
	WebElement ConfirmButton;
	
	@FindBy(css=".alert-success")
	WebElement ConfirmPayment;
	
	@FindBy(css="[id=credit_card_number]")
	WebElement CreditCardNumber;
	
	@FindBy(id="expiration_date")
	WebElement ExpirationDate;
	
	@FindBy(css="#cvv")
	WebElement CVV;
	
	@FindBy(xpath="//input[@data-test='card_holder_name']")
	WebElement CardHolderName;
	
	@FindBy(xpath="//div[@id='order-confirmation']/span")
	WebElement OrderID;
	
	
	
	public WebElement confirmButton()
	{
		return ConfirmButton;
	}
	
	public void OrderConfirmation()
	{
		waitForTheVisibilityOfElement(ConfirmPayment);
		if(ConfirmPayment.isDisplayed())
			System.out.println("Order is placed");
		else
			System.out.println("Payment failed");
	}
	
	public void CODPayment()
	{
		selectFromdropDownByValue(PaymentDropdown,"cash-on-delivery");
		clickElement(ConfirmButton);
		OrderConfirmation();
		
	}
	public String ordernum=null;
	public void creditCardPayment() throws IOException
	{
		selectFromdropDownByValue(PaymentDropdown,"credit-card");
		CreditCardNumber.sendKeys(GetValue("CardNumber"));
		ExpirationDate.sendKeys(GetValue("ExpiryDate"));
		CVV.sendKeys(GetValue("CVV"));
		CardHolderName.sendKeys(GetValue("Name"));
		clickElement(ConfirmButton);
		OrderConfirmation();
		confirmButton().click();
		waitForTheVisibilityOfElement(OrderID);
		System.out.println(OrderID.getText());
		ordernum=OrderID.getText();
		System.out.println(ordernum);
		
		
		
	}
	
	/*public String invoiceNumber(String orderid)
	{
		
		orderid=OrderID.getText().toString();
		return orderid;
	}*/

}
