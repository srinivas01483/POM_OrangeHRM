package TestScenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Utils.AppUtils;

public class TC_02_AdminLoginTestwithInvalidData extends AppUtils{

	LoginPage_POM lp;
	
	@Parameters({"adminuid","adminpwd"})
	@Test(priority = 1)
	public void checkAdminlogin(String uid,String pwd)
	{
		
		lp=new LoginPage_POM(driver);
		
		lp.login(uid, pwd);
		boolean res=lp.ErrormessageDisplayed();
		Assert.assertTrue(res, "Error Mesage not Displayed Test Fail");
		
	}
	
	
}
