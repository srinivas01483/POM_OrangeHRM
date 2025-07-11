package TestScenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.GoogleSearchPage;
import Objects.LoginPage_POM;
import Utils.AppUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_AdminLoginTestwithValidData extends AppUtils {

	//
	LoginPage_POM lp;
	
	
	@Parameters({"adminuid","adminpwd"})
	@Test(priority = 0)
	public void SearchOperation(String uid,String pwd)
	{
		
		
		//LoginPage_POM lp = PageFactory.initElements(driver, LoginPage_POM.class);
		 lp=new LoginPage_POM(driver);
		lp.login(uid, pwd);
		boolean res=lp.isAdminModuleDisplayed();
		Assert.assertTrue(res, "admin link not displayed Tets Fail");
		lp.logout();
	}
	
}
