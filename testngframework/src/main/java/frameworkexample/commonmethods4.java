package frameworkexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class commonmethods4
{
	WebDriver driver;
	public commonmethods4(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@routerlink=\"/dashboard/cart\"]")
	WebElement addtocart;
	
	public void elementovisible(By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void elementtoclickable(By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void elementtobeinvisible(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void gotocart()
	{
		addtocart.click();
		
	}
	

}
