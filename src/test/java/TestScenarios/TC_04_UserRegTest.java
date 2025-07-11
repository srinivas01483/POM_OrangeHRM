package TestScenarios;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.AdminPage;
import Objects.LoginPage_POM;
import Utils.AppUtils;

public class TC_04_UserRegTest extends AppUtils{
	
	
	@Parameters({"adminuid","adminpwd","role","fname","uname","pword"})
	@Test(priority = 4)
	public void checkUserReg(String adminuid,String adminpwd,String role,String fname,String uname,String pword ) throws InterruptedException
	{
		
		LoginPage_POM lp=new LoginPage_POM(driver);
		AdminPage ap=new AdminPage(driver);
		lp.login(adminuid, adminpwd);
		
		ap.navigateToAdmin();
		ap.clickAddbtn();
		ap.selectByVisibleRole(role);
		ap.addUserDetails(fname, uname, pword);
		ap.Savebtn();
		
		boolean result=ap.searchEmployeeAndVerify(uname);
		assertTrue(result, "New user not found in the search results");
		lp.logout();
		
	}

}
