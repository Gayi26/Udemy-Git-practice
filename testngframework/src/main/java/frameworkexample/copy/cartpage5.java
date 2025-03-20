package frameworkexample.copy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartpage5 extends commonmethods4 {
	WebDriver driver;

	public cartpage5(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class=\"cartSection\"]/h3")
	List<WebElement> cartproducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	public List<WebElement> products(){
		return cartproducts;
	}
	public Boolean cartproductsver(String product)
	{
		
		 Boolean match=products().stream().anyMatch(cartproduct->cartproduct.getText().equals(product));
		 return match;
		
	}
	public void checkout()
	{
		checkout.click();
		
	}

}
