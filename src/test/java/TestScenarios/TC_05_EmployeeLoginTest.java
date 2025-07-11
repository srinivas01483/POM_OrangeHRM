package TestScenarios;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Utils.AppUtils;

public class TC_05_EmployeeLoginTest extends AppUtils {

	LoginPage_POM lp;
	
	@Parameters({"empname","emppwd"})
	@Test(priority = 4)
	public void CheckEmployeeLogin(String empname,String emppwd)
	{
		 lp=new LoginPage_POM(driver);
		 lp.login(empname, emppwd);
		 
		 boolean res= lp.isAdminModuleDisplayed();
		 
		Assert.assertTrue(res, "Admin module not Displayed test fail");
		
		
	}
}
