package testngframework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class placingorder extends commonmethods {
	WebDriver driver;
	public placingorder(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement country;
	@FindBy(xpath="//button[@class=\"ta-item list-group-item ng-star-inserted\"]/..//span[text()=' India']")
	WebElement name;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorder;
	@FindBy(xpath="//div[@class=\"actions\"]/..//a[@class=\"btnn action__submit ng-star-inserted\"]")
	WebElement submit;
	@FindBy(xpath="//h1[@class=\"hero-primary\"]")
	WebElement orderconfirmation;
	By order=By.xpath("//a[text()='Place Order ']");
	public void placingorder() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, "India").build().perform();
		name.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);
		elementtoappear(order);
		Thread.sleep(3000);
		submit.click();
		String confirmmessage=orderconfirmation.getText();
        Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		
	}

}
