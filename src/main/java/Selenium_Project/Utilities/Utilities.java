package Selenium_Project.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForTheVisibilityOfElements(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForTheInvisibilityOfElement(WebElement message)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(message));
	}
	public void waitForTheVisibilityOfElement(WebElement message)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(message));
	}
	
	public static String GetValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream
				(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium_Project\\Resources\\GlobalData.properties");
		prop.load(fis);
	    return prop.getProperty(key);
	}
	
	public void selectFromdropDownByValue(WebElement ele,String value)
	{
		Select select=new Select(ele);
		select.selectByValue(value);
		
	}
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	

}
