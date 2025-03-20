package testngframework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class orderspage extends commonmethods{
	WebDriver driver;
    public orderspage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//tr[@class=\"ng-star-inserted\"]/..//td[2]")
   List<WebElement> allproducts;
    public void orders() throws InterruptedException
    {
    	gotoorderspage();
    	for(WebElement pro:allproducts)
    	{
    		String product=pro.getText();
    		Assert.assertEquals(product, "ZARA COAT 3");
    	}
    	
    	
    }
    

}
