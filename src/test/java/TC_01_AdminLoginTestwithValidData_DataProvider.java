import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Utils.AppUtils;

public class TC_01_AdminLoginTestwithValidData_DataProvider extends AppUtils {
	
	LoginPage_POM lp;
	
	//Setup for data provider
	
	@DataProvider(name = "AdminLoginTest")
	public Object[][] getAdminLoginData()
	{
		return new Object[][] {
			
			{"Admin","Qedge123!@#"},
			{"Test_sri1","QedgewQ1234!@#$"},
			{"adm","1234"},
			//{"Admin","Qedge123!@#"}
			
			
		};
	}
	
	//mention  test name in the dataprovider
	
	@Test(dataProvider  ="AdminLoginTest" )
	public void SearchOperation(String uid,String pwd)
	{

		 lp=new LoginPage_POM(driver);
		lp.login(uid, pwd);
		boolean res=lp.isAdminModuleDisplayed();
		Assert.assertTrue(res, "admin link not displayed Tets Fail");
		lp.logout();
	}
	

}
