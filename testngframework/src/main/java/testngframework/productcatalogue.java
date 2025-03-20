package testngframework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productcatalogue extends commonmethods{
	WebDriver driver;
	public productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> products1;
	public List<WebElement> getproductlist()
	{
		return products1;
	}

}
