import java.util.function.ObjDoubleConsumer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Objects.PIMPage;
import Utils.AppUtils;

public class TC_03_PIMTest_DataProvider extends AppUtils{
	
	
	//do not mention Webdriver here
	LoginPage_POM lp;
	PIMPage pimPage;
	
	@DataProvider(name="addEmployee")
	public Object[][] getaddEmployee()
	{
		return new Object[][]
				{
			{"Admin","Qedge123!@#","srinivas","Balasani"},
			{"Admin","Qedge123!@#","shiva","Balasani"},
			
				};
	}

	@Test(dataProvider ="addEmployee" )
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
