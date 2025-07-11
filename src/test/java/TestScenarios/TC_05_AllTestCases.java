package TestScenarios;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.AdminPage;
import Objects.LoginPage_POM;
import Objects.PIMPage;
import Utils.AppUtils;

public class TC_05_AllTestCases extends AppUtils{
	
		LoginPage_POM lp;
		PIMPage pimPage;
		AdminPage ap;
		
		
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

	@Parameters({"adminuid","adminpwd"})
	@Test(priority = 1)
	public void checkAdminlogin(String uid,String pwd)
	{
		
		lp=new LoginPage_POM(driver);
		
		lp.login(uid, pwd);
		boolean res=lp.ErrormessageDisplayed();
		Assert.assertTrue(res, "Error Mesage not Displayed Test Fail");
		
	}
	
	
	@Parameters({"adminuid","adminpwd","fname","lname"})
	@Test(priority = 2)
	public void verifyEmployeeSearchByName(String uid,String pwd,String fname,String lname) throws InterruptedException
	{
		
		
		lp=new LoginPage_POM(driver);
		pimPage=new PIMPage(driver);
		
		lp.login(uid, pwd);
		pimPage.navigatetoPIM();
		
		pimPage.clickAddEmployee();
		
		pimPage.addEmployee(fname, lname);
	
		boolean res= pimPage.SearchAndverifyEmployeetableData(fname);
		
		
		Assert.assertTrue(res,"employeename not found in the table");
		
		
	}
	

	@Parameters({"adminuid","adminpwd","role","fname","uname","pword"})
	@Test(priority = 3)
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
