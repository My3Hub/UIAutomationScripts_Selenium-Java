package Selenium_Project.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Project.Utilities.Utilities;

public class FavoritesPage extends Utilities {
	WebDriver driver;
	
	public FavoritesPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[text()='Pliers']")
	WebElement CombinationPliers;
	
	@FindBy(css="button[data-test='delete']")
	WebElement DeleteButton;
	
	
	
	public String getItemName()
	{
		String name=CombinationPliers.getText();
		return name;
	}
	

}
