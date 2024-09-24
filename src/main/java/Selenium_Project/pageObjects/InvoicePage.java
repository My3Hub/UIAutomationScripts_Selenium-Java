package Selenium_Project.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Selenium_Project.Utilities.Utilities;

public class InvoicePage extends Utilities {
	WebDriver driver;

	public InvoicePage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[id='order-confirmation']")
    WebElement OrderCofirmationMessage;
	
	@FindBy(xpath="//th[text()='Invoice Number']")
	WebElement InvoiceNumberTitle;
	
	@FindBy(css=".table-hover tbody tr td:nth-child(1)")
	List<WebElement> Invoices;
	
	By Orders = By.cssSelector(".table-hover tbody tr td:nth-child(1)");
	
	public void invoicesList()
	{
		waitForTheVisibilityOfElement(InvoiceNumberTitle);
		for(int i=0;i<Invoices.size();i++)
		{
			System.out.println(Invoices.get(i).getText());
			
			PaymentsPage pay=new PaymentsPage(driver);
			//Boolean match=Invoices.stream().anyMatch(invoice->invoice.getText().contains(pay.ordernum));
			Boolean match=Invoices.stream().anyMatch(invoice->invoice.getText().equals(pay.ordernum));
			Assert.assertTrue(match);
		}
		
		
		
	}
}

	
