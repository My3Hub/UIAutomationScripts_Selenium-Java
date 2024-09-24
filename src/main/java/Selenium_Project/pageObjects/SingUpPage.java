package Selenium_Project.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Selenium_Project.Utilities.Utilities;

public class SingUpPage extends Utilities {

	WebDriver driver;

	public SingUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void Registration() throws IOException, InterruptedException {

		driver.findElement(By.cssSelector("[data-test='nav-sign-in']")).click();
		driver.findElement(By.cssSelector("[data-test='register-link']")).click();
		// Thread.sleep(5000);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\Selenium_Project\\Resources\\GlobalData.properties");
		prop.load(fis);
		driver.findElement(By.id("first_name")).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.id("last_name")).sendKeys(prop.getProperty("LastName"));
		driver.findElement(By.id("dob")).sendKeys(prop.getProperty("DOB"));
		driver.findElement(By.id("address")).sendKeys(prop.getProperty("Address"));
		driver.findElement(By.cssSelector("[data-test='postcode']")).sendKeys(prop.getProperty("Zipcode"));
		driver.findElement(By.cssSelector("[id='city']")).sendKeys(prop.getProperty("City"));
		driver.findElement(By.id("state")).sendKeys(prop.getProperty("State"));
		Select s = new Select(driver.findElement(By.id("country")));
		s.selectByValue(prop.getProperty("Country"));
		driver.findElement(By.id("phone")).sendKeys(prop.getProperty("Phone"));
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.cssSelector("[type=submit]")).click();

	}

}
