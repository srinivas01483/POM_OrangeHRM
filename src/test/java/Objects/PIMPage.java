package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

	WebDriver driver;
	
	WebDriverWait wait;
	public PIMPage(WebDriver driver)
	{
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	//Object Repository
	
	@FindBy(linkText = "PIM")
	WebElement PIM_Menu;
	
	@FindBy(linkText = "Add Employee")
	WebElement AddEmployee_btn;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="employeeId")
	WebElement empid;
	
	@FindBy(xpath = "(//input[@type='button'])[4]")
	WebElement save_btn;
	
	@FindBy(linkText = "Employee List")
	WebElement employeeList_btn;
	
	@FindBy(name = "empsearch[employee_name][empName]")
	WebElement employeenamesearch;
	
	@FindBy(id = "empsearch_id")
	WebElement employeeId;
	
	@FindBy(id = "searchBtn")
	WebElement search_btn;
	
	
	//Actions
	
	public void navigatetoPIM()
	{
		
		PIM_Menu.click();
	}
	
	public void clickAddEmployee()
	{
		AddEmployee_btn.click();
		
	}
	
	public void  addEmployee(String fname,String lname)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		String empid_value=empid.getAttribute("value");
		save_btn.click();
		
		
	}

	
	public boolean  SearchAndverifyEmployeetableData(String empname) throws InterruptedException
	{
		
		
		employeeList_btn.click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(employeenamesearch));
		employeenamesearch.sendKeys(empname);
		
		//employeeId.sendKeys(empid_value);
		search_btn.click();
		
	  By tableLocator=By.id("resultTable");
      wait.until(ExpectedConditions.presenceOfElementLocated(tableLocator));
          
      //Always use fresh refrence
		WebElement userTable=driver.findElement(By.id("resultTable"));
		List<WebElement>rows;
		rows=userTable.findElements(By.tagName("tr"));
		
		
		boolean res = false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(2).getText().equals(empname))
			{
				res = true;
				break;
			}
 		}
		
		return res;
			}
				
	}
	

