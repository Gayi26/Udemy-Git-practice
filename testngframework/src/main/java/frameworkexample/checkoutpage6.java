package frameworkexample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testngframework.commonmethods;

public class checkoutpage6 extends commonmethods{
	WebDriver driver;

	public checkoutpage6(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement selectcountry;
	@FindBy(xpath="//span[text()=' India']")
	WebElement India;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorder;
	@FindBy(xpath="//h1[@class=\"hero-primary\"]")
	WebElement thankyou;
	By check=By.xpath("//section[contains(@class,\"list-group ng-star-inserted\")]");
	By order=By.xpath("//h1[@class=\"hero-primary\"]");
	
	public void selectcountry(String country)
	{
		Actions a=new Actions(driver);
		a.sendKeys(selectcountry, country).build().perform();
		elementtovisible(check);
		India.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);
		js.executeScript("arguments[0].click()",placeorder);

	}
	public String confirmmessage()
	{
		String thanks=thankyou.getText();
		return thanks;
	}
}
