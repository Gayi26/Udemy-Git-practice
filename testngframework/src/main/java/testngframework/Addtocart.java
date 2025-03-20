package testngframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocart extends commonmethods{
	WebDriver driver;
	public Addtocart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[contains(text(),'Cart')]")
	WebElement cart;
	By findby=By.xpath("//div[text()=' Product Added To Cart ']");
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cartitems;
	public void adding()
	{
		elementtoappear(findby);
		cart.click();
	}
	public List<WebElement> items()
	{
		return cartitems;
	}

}
