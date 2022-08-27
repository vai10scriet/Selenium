package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy (css="[name='email']")
	WebElement email;
	
	@FindBy (css="[name=' password']") 
	WebElement password;
	
	@FindBy (css="[value='Log In']")
	WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void getEmail(String emailtxt)
	{
		
		email.sendKeys(emailtxt);
	}

	
	public void getPassword(String passwordtxt)
	{
		
		password.sendKeys(passwordtxt);
	}
	
	public void getLogin()
	{
		
		login.click();
	}
}
