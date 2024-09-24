package Selenium_Project.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Selenium_Project.TestComponents.BaseTest;
import Selenium_Project.pageObjects.CheckOutPage;
import Selenium_Project.pageObjects.HomePage;
import Selenium_Project.pageObjects.InvoicePage;
import Selenium_Project.pageObjects.PaymentsPage;

public class E2E extends BaseTest {
	
	//PaymentsPage pay;
	
	/*@Test
	public void submitOrder_COD() throws IOException {
		// TODO Auto-generated method stub

		
		HomePage home = new HomePage(driver);
		home.MyAccountMenu();
		home.getProducts();
		home.getProductName("Pliers");
		home.addItemToCart();
		CheckOutPage cop1 = home.checkOut();
		cop1.CheckOut1();
		cop1.CheckOut2();
		pay=cop1.BillingAddress();
		pay.CODPayment();
		
	
}*/
	@Test
	public void submitOrder_Creditcard() throws IOException
	{
		
		HomePage home = new HomePage(driver);
		
		home.MyAccountMenu();
		home.getProducts();
		home.getProductName("Pliers");
		home.addItemToCart();
		CheckOutPage cop1 = home.checkOut();
		cop1.CheckOut1();
		cop1.CheckOut2();
		PaymentsPage pay=new PaymentsPage(driver);
		pay=cop1.BillingAddress();
		pay.creditCardPayment();
		//pay.confirmButton().click();
		
		
	}
	@Test(dependsOnMethods= {"submitOrder_Creditcard"})
	public void validateInvoice() throws InterruptedException
	{
		
		HomePage home = new HomePage(driver);
		InvoicePage invoice=new InvoicePage(driver);
		//PaymentsPage pay=new PaymentsPage(driver);
		//pay.invoiceNumber("orderid");
		home.MyAccountMenu();
		home.goToInvoicePage();
		invoice.invoicesList();
		
	}
}
