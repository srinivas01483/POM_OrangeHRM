package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Objects.LoginPage_POM;

public class AppUtils {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void launchApp()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://orangehrm.qedgetech.com");

		
	}

	@AfterSuite
	public void closeApp() 
	{
		
		driver.quit();
		
	}

}
