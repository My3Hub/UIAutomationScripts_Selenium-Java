package Selenium_Project.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Selenium_Project.pageObjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream
			(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium_Project\\Resources\\GlobalData.properties");
	prop.load(fis);
	String BrowserName=prop.getProperty("browser");
	if(BrowserName.equalsIgnoreCase("chrome"))
	{
		
	ChromeOptions options = new ChromeOptions();
	 options.setExperimentalOption("excludeSwitches",
	      Arrays.asList("disable-popup-blocking"));
//	 options.addArguments("--disable-extensions");
//	 options.addArguments("test-type");
//     Map<String, Object> prefs = new HashMap<String, Object>();
//     prefs.put("credentials_enable_service", false);
//     prefs.put("profile.password_manager_enabled", false);
//     options.setExperimentalOption("prefs", prefs);
	 options.addArguments("--incognito");
	 
	
	driver=new ChromeDriver(options);
    
	}
	else if(BrowserName.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","edge.exe");
		driver=new EdgeDriver();
	    
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
	}

	

public LoginPage launchApplication() throws IOException
{
	driver=initializeDriver();
	LoginPage loginpage=new LoginPage(driver);
	loginpage.goTo();
	return loginpage;
	
}

@BeforeTest
public void CreateanAccount() throws IOException, InterruptedException
{
	LoginPage loginPage=launchApplication();
	loginPage.SignIn();
	
}

public String getScreenshot(String testcasename,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir")+"//reports//"+ testcasename +".png");
	FileUtils.copyFile(source,file);
	return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
}






}


