package frameworkexample.copy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderspage8 extends commonmethods4
{

	public orderspage8(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement orders;
	@FindBy(xpath="//table[@class=\"table table-bordered table-hover ng-star-inserted\"]//tr//td[2]")
	List<WebElement>productnames;
	public List<WebElement> productnames()
	{
		return productnames;
	}
	public Boolean productverification(String Product) throws InterruptedException
	{
		orders.click();
		Thread.sleep(2000);
		Boolean result=productnames().stream().anyMatch(prod->prod.getText().contains(Product));
		return result;
	}

}
