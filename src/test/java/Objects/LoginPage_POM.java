package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_POM {

	WebDriver driver;
	
	public LoginPage_POM(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//object repository
	
	@FindBy(xpath =  "//input[@id='txtUsername']")
	WebElement uid_element;
	
	@FindBy(id="txtPassword")
	WebElement pwd_element;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login_element;
	
	@FindBy(linkText = "Admin")
	WebElement admin_link;
	
	@FindBy(partialLinkText = "Welcome")
	WebElement partial_linktext;
	
	@FindBy(linkText = "Logout")
	WebElement logout_link;
	
	
	
	@FindBy(xpath = "//span[@id='spanMessage']")
	WebElement erroeMessage_element;
	
	
	//Create methods
	public void login(String uid,String pwd)
	{
		uid_element.sendKeys(uid);
		pwd_element.sendKeys(pwd);
		login_element.click();
		
		
	}
	
	public boolean isAdminModuleDisplayed()
	{
		
		try {
			
			if(admin_link.isDisplayed())
			{
				System.out.println("Admin link is displayed test pass");
				return true;
			
			}else {
				
				System.out.println("Admin link is noy displayed -test fail");
			}
				
					
		} catch (Exception e) {
			System.out.println("Admin link is not displayed test fail "+e.getMessage());
		}
		return false;
	
		
		
	}
	
	public boolean ErrormessageDisplayed()
	{
			try {
				
				if(erroeMessage_element.isDisplayed())
				{
					System.out.println("Error Message Displayed -Test Pass");
					return true;
				}else
				{
					System.out.println("Error Message is noy displayed -test fail");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			return false;
			
		
		
		
		//Assert.assertTrue(erroeMessage_element.isDisplayed());
		//System.out.println(erroeMessage_element.getText());
		
	}
	
	
	public void logout()
	{
		
		partial_linktext.click();
		logout_link.click();
		
		
	}
	
}

