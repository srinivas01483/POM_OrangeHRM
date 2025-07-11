package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	
	WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver) //Create Constructor

	{
		

		this.driver=driver;		
		
	}
	

	By SearchBox=By.xpath("//textarea[@id='APjFqb']");
	By searchBtn=By.xpath("(//input[@name='btnK'])[1]");
	

	public void Searchgoogle(String searchinput)
	{
		
		
		try {
			
			driver.findElement(SearchBox).sendKeys(searchinput);
			
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			
			System.out.println("Exceptions caught "+e.getMessage());
		}
		
		
	}
	
	
}
