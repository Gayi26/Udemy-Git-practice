package frameworkexample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.netty.handler.pcap.PcapWriteHandler;

public class standalonetest1 {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String Product="ZARA COAT 3";
		String country="India";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		landingpage2 page=new landingpage2(driver);
		page.navigate();
		page.loggingin("jennie123@gmail.com", "Jennie123");		
		productcatalogue3 pc=new productcatalogue3(driver);
		 List<WebElement> allproducts = pc.products();
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 boolean res= pc.addtocart(Product);
		System.out.println(res);		
		commonmethods4 cm=new commonmethods4(driver);
		cm.gotocart();
		cartpage5 cp=new cartpage5(driver);
		Boolean match=cp.cartproductsver(Product);
		Assert.assertTrue(match);
		cp.checkout();
		checkoutpage6 ch=new checkoutpage6(driver);
		ch.selectcountry(country);
		String message=ch.confirmmessage();		
		Assert.assertEquals(message,"THANKYOU FOR THE ORDER.");
		
	}

	
}
