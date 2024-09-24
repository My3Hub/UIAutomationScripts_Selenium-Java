package Selenium_Project.pageObjects;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_Project.Utilities.Utilities;

public class LoginPage extends Utilities {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[data-test='nav-sign-in']")
	WebElement SignInButton;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(css="[type='password']")
	WebElement Password;

	@FindBy(className="btnSubmit")
	WebElement SubmitButton;
	
	@FindBy(css=".google-sign-in-button")
	WebElement SignInWithGoogle;
	
	@FindBy(css=".help-block")
	WebElement EmailExistsMessage;
	
	public void SignIn() throws IOException, InterruptedException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream
				(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium_Project\\Resources\\GlobalData.properties");
		prop.load(fis);
		SignInButton.click();
		SingUpPage sign=new SingUpPage(driver);
		sign.Registration();
		Thread.sleep(1000);
		try {
		
		if(EmailExistsMessage.isDisplayed())
		{
		username.clear();
		username.sendKeys("xyz@gmail.com");
		SignInButton.click();
		String title=driver.getTitle().toString();
		System.out.println(title);
		waitForTheVisibilityOfElement(SignInWithGoogle);
		username.sendKeys(prop.getProperty("Email"));
		waitForTheVisibilityOfElement(SignInWithGoogle);
		Password.sendKeys(prop.getProperty("Password"));
		waitForTheVisibilityOfElement(SubmitButton);
		SubmitButton.click();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);

			SignInButton.click();
			waitForTheVisibilityOfElement(SignInWithGoogle);
			username.clear();
			username.sendKeys(prop.getProperty("Email"));
			waitForTheVisibilityOfElement(SignInWithGoogle);
			Password.clear();
			Password.sendKeys(prop.getProperty("Password"));
			waitForTheVisibilityOfElement(SubmitButton);
			SubmitButton.click();
		}
		}
		
		
	
	public void goTo()
	{
		 driver.get("https://practicesoftwaretesting.com/");
	}
}
