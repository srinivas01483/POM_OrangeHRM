package TestScenarios_Excel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Objects.LoginPage_POM;
import Utils.AppUtils;
import Utils.ExcelUtils;

public class TC_ExcelDataProvider_AdminLoginValidData extends AppUtils {

	LoginPage_POM lp;
	
	@DataProvider(name ="excelData")
	public Object[][] getExcelData() throws IOException{
		String filePath="C:/users/EmployeeData_OrangeHRM.xlsx";
		String sheetName="Sheet1";
		
	try {
		return ExcelUtils.getTableArray(filePath, sheetName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
		
	};
	
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
