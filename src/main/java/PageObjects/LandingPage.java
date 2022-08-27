package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	@FindBy (css="a[href*='sign_in']")
	WebElement signin;
	
	@FindBy (css=".text-center>h2")
	WebElement title;
	
	@FindBy (css=".nav.navbar-nav.navbar-right>li>a")
	WebElement navbar;
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}


	public void getLogin()
	{
		
		signin.click();
	}
	
	public String getTexts()
	{
		
		return title.getText();
	}
	
	public boolean getNav()
	{
		return navbar.isDisplayed();
		
	}

}
