package frameworkexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage2 extends commonmethods4 {
	WebDriver driver;

	public landingpage2(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userpassword;
	@FindBy(id="login")
	WebElement login;
	public void navigate()
	{
		driver.get("https://rahulshettyacademy.com/client");

	}
	public void loggingin(String email,String password)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		login.click();
		
	}
}
