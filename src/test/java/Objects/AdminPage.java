package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage {

	WebDriver driver;
	
	WebDriverWait wait;
	
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		
	}
	
	//Object Repository
	
	@FindBy(linkText = "Admin")
	WebElement adminLinkText;
	
	@FindBy(linkText = "User Management")
	WebElement userManagementLinkText;
	
	@FindBy(linkText = "Users")
	WebElement userlinkText;
	
	@FindBy(xpath = "//input[@name='btnAdd']")
	WebElement addBtn;
	
	@FindBy(id = "systemUser_userType")
	WebElement userRole;
	
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(id = "systemUser_userName")
	WebElement userName;
	
	@FindBy(id = "systemUser_password")
	WebElement passWord;
	
	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(xpath  = "//input[@id='btnSave']")
	WebElement btnSave;
	
	
	@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	WebElement empidSearch;
	
	@FindBy(id = "searchBtn")
	WebElement empSearchButton;
	
	// Action performing on Elements
	public void navigateToAdmin()
	{
		adminLinkText.click();
		userManagementLinkText.click();
		userlinkText.click();
		
	}
	
	public void clickAddbtn()
	{
		addBtn.click();
		
	}
	
	
	public void selectByVisibleRole(String role)
	{
		Select select=new Select(userRole);
		select.selectByVisibleText(role);
		
	}
	
	public void addUserDetails(String ename,String uname,String pwd)
	{
		empName.sendKeys(ename);
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		
		
	}
	
	public void Savebtn() throws InterruptedException
	{
		
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(btnSave));
	btnSave.click();
		
		
	}
	
	public boolean searchEmployeeAndVerify(String uname)
	{
		wait.until(ExpectedConditions.visibilityOf(empidSearch));
		empidSearch.sendKeys(uname);
		empSearchButton.click();
		
		// to avoid stale element exception use this csript 116 to119
		By tablelocator=By.id("resultTable");
		wait.until(ExpectedConditions.presenceOfElementLocated(tablelocator));
		
		WebElement userTable=driver.findElement(tablelocator);
		
		List<WebElement>rows;
		rows=userTable.findElements(By.tagName("tr"));
		
		
		boolean res = false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(uname))
			{
				res = true;
				break;
			}
 		}
		
		return res;
		
	}
		
	}
	
			
			

