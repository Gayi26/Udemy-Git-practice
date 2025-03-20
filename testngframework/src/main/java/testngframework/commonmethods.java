package testngframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonmethods {
	WebDriver driver;
	@FindBy(xpath="//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement orders;
	
	public commonmethods(WebDriver driver) {
		this.driver=driver;
	}

	public void elementtoappear(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void elementtovisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public orderspage gotoorderspage() throws InterruptedException
	{
		Thread.sleep(4000);
		elementtovisible(orders);
		orders.click();
		orderspage orders=new orderspage(driver);
		return orders;
		
	}

}
