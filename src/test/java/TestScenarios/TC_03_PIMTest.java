package TestScenarios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Objects.PIMPage;
import Utils.AppUtils;

public class TC_03_PIMTest extends AppUtils{
	
	//WebDriver driver;
	LoginPage_POM lp;
	PIMPage pimPage;
	
	@Parameters({"adminuid","adminpwd","fname","lname"})
	@Test(priority = 3)
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
		lp.logout();
		
		
	}
	
	
}
