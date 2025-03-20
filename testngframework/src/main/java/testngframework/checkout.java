package testngframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout extends commonmethods {
	WebDriver driver;
	public checkout(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement ele;
	public void checkout()
	{
		checkout.click();
		elementtovisible(ele);
	}
	

}
