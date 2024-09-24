package Selenium_Project.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Project.Utilities.Utilities;

public class HomePage extends Utilities {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[data-test='nav-sign-in']")
	WebElement SignInButton;
	
	@FindBy(css="[data-test='nav-home']")
	WebElement HomeButton;
	
	@FindBy(xpath="//div[@class='card-img-wrapper']/img[@alt='Pliers']")
	WebElement Product;
	
	@FindBy(xpath="//button[@id='btn-add-to-cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//div[@aria-label='Product added to shopping cart.']")
	WebElement CartUpdateMessage;
	
	@FindBy(css="a[aria-label='cart']")
	WebElement Cart;
	
	@FindBy(css="[data-test='add-to-favorites']")
	WebElement AddToFavorites;
	
	@FindBy(css="h5[data-test='product-name']")
	List<WebElement> Products;
	
	By items=By.cssSelector("h5[data-test='product-name']");
	
	@FindBy(css="[aria-label='Product added to your favorites list.']")
	WebElement UpdateOnFavoritesList;
	
	@FindBy(css="[id='lblCartCount']")
	WebElement CartCount;
	
	@FindBy(css="[id='menu']")
	WebElement MyAccount;
	
	/*public void AddItemToCart()
	{
		HomeButton.click();
		Product.click();
		AddToCart.click();
		waitForTheVisibilityOfElement(CartUpdateMessage);
		waitForTheInvisibilityOfElement(CartUpdateMessage);
		Cart.click();
	}*/
	
	@FindBy(css="[data-test='nav-my-invoices']")
	WebElement InvoiceOption;
	public void MyAccountMenu() {
		
		
		waitForTheVisibilityOfElement(MyAccount);
	}
	
	public InvoicePage goToInvoicePage()
	{
		MyAccount.click();
		waitForTheVisibilityOfElement(InvoiceOption);
		InvoiceOption.click();
		InvoicePage invoice=new InvoicePage(driver);
		
		return invoice;
	}
	public List<WebElement> getProducts()
	{
		HomeButton.click();
		waitForTheVisibilityOfElements(items);
		return Products;
	}
	
	public void getProductName(String productName)
	{
		Products.stream().filter(product->product.getText().equals("Pliers")).findFirst().orElse(null).click();
		
	}
	public void addItemToCart() {
		AddToCart.click();
		waitForTheVisibilityOfElement(CartUpdateMessage);
		waitForTheInvisibilityOfElement(CartUpdateMessage);
	}
	
	public CheckOutPage checkOut()
	{
		Cart.click();
		CheckOutPage cop1=new CheckOutPage(driver);
		return cop1;
	}
	
	public void addItemToFavorites()
	{
		AddToFavorites.click();
		waitForTheVisibilityOfElement(UpdateOnFavoritesList);
		waitForTheInvisibilityOfElement(UpdateOnFavoritesList);
		
	}
	
	
}
