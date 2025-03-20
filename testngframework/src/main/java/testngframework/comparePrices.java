package testngframework;
import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class comparePrices {

	public static void main(String[] args) throws MalformedURLException, InterruptedException, AWTException {
		
		//Amazon Application Desired Capability and launching amazon application
		
		String amazonPricetext = "";
        String amazonDeliverytext = "";
        String flipkartPricetext = "";
        String flipkartDeliverytext = "";
        String pincode="831003";
        String SearchProduct="iPhone 14 black 256 gb";
		
		DesiredCapabilities cap1=new DesiredCapabilities();
		cap1.setCapability("appPackage","in.amazon.mShop.android.shopping");
		cap1.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
		cap1.setCapability("noReset",true);
		cap1.setCapability("autoGrantPermissions",true);
		cap1.setCapability("platformName", "Android");
		URL url1=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url1, cap1);
		System.out.println("Amazon application launched");
		
		//Storing Amazon application driver instance in an variable
		AndroidDriver AmazonDriverInstance=driver;
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		//Enter the product into the search text field
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//android.widget.LinearLayout[@content-desc=\"Search\"])[2]")))).click();
		WebElement searchBoxAmazon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.EditText[@text=\"Search Amazon.in\"]"))));
		searchBoxAmazon.sendKeys(SearchProduct);
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.View[@index='1']")))).click();
		Thread.sleep(4000);
		amazonPricetext=driver.findElement(By.xpath("//android.widget.TextView[@index=\"2\"]")).getText();
		System.out.println(amazonPricetext);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"delivery\")]")))).click();
	
		//Fetching price of the product
		Integer amazonprice=0;
		String price="";
		int amazondelivery=0;
		for(int i=0;i<amazonPricetext.length();i++)
		{
			if(amazonPricetext.charAt(i)>='0' && amazonPricetext.charAt(i)<='9')
			{
				price=price+amazonPricetext.charAt(i);
						
			}
		}
		amazonprice=Integer.parseInt(price);
		//amazonprice variable consists price of the product in amazon
		System.out.println(amazonprice);
		
		
		Thread.sleep(4000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'delivery')]")) );
		
		 boolean isElementFound = false;

	        while (!isElementFound) 
	        {
	            try {
	                // Try to find the element
	                WebElement element = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'delivery')]"));
	                if (element.isDisplayed()) 
	                {
	                    isElementFound = true;
	                }
	                }
	                
	            catch (Exception e) {
	                // If the element is not found, scroll down
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'delivery')]")) );
//	                HashMap<String, String> scrollObject = new HashMap<>();
//	                scrollObject.put("direction", "down");
//	                js.executeScript("mobile: scrollGesture", scrollObject);
	            
	            	}
	            
	        }
		
		
		
		
	
		amazonDeliverytext=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'delivery')]")).getText();
		
		
//		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'delivery')]/../../../following-sibling::android.view.View//android.widget.TextView")).click();
		
		
		
		
		
		
		
		
//		amazonDeliverytext=driver.findElement(By.xpath("")).getText();
//		
//		driver.findElement(By.xpath("(//android.widget.TextView[@index=\"0\"])[3]")).click();
		
		
		
		
		
		System.out.println(amazonDeliverytext);
		
		System.out.println(amazondelivery);
		
		
		
		
		
		

				

//		
//		
//		//Flipkart Application Desired Capability and launching Filpkart application
//		
//		DesiredCapabilities cap2=new DesiredCapabilities();
//		cap2.setCapability("appPackage","com.flipkart.android");
//		cap2.setCapability("appActivity","com.flipkart.android.SplashActivity");
//		cap2.setCapability("noReset",true);
//		cap2.setCapability("autoGrantPermissions",true);
//		cap2.setCapability("platformName", "Android");
//		URL url2=new URL("http://localhost:4723/wd/hub");
//		driver=new AndroidDriver(url2, cap2);
//		
//		//Storing Filpkart application driver instance in an variable
//		AndroidDriver FlipkartDriverInstance=driver;
//		
//		System.out.println("Flipkart application launched");
//		
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Explore\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.flipkart.android:id/search_icon\"]")).click();
//		
//		Thread.sleep(2000);
//		WebElement searchBoxFlipkart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.EditText[@text=\"Search for products\"]"))));
//		searchBoxFlipkart.sendKeys(SearchProduct);
//		
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text=\"iphone 14 black 256 gb\"]")))).click();
//		
//		
//		flipkartPricetext=driver.findElement(By.xpath("//android.widget.TextView[@index=\"10\"]")).getText();
//		System.out.println(flipkartPricetext);
//		driver.findElement(By.xpath("//android.widget.TextView[@index=\"10\"]")).click();
//		
//		//Scroll untill delivery
//		
////		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter pincode\"]")).sendKeys(pincode);
////		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Submit \"]")).click();
//		
//		int flipkartprice=0;
//		int flipkartdelivery=0;
//		
//		if(driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter pincode\"]")).isDisplayed())
//		{
//			System.out.println("Product is not devlivered to this pincode and it is better to go amazon");
//		}
//		else {
////		flipkartDeliverytext=driver.findElement(By.xpath("//android.widget.TextView[@text=\"₹72,200.00 with 20 percent savings\"]")).getText();
////		System.out.println(flipkartDeliverytext);
//		}
//
//		
//		
//		
//		if(amazonprice>flipkartprice && amazondelivery>flipkartdelivery)
//		{
//			System.out.println("Flipkart price is lower and can deliver early");
//			//launch flipkart
//			
//		}
//		else if(flipkartprice>amazonprice && flipkartdelivery>amazondelivery)
//		{
//			System.out.println("Amazon price is lower and can deliver early");
//			//launch amazon
//		}
//		else if(amazonprice==flipkartprice && amazondelivery==flipkartdelivery)
//		{
//			System.out.println("Go for any app for your choice");
//			//launch amazon or flipkart
//		}
//		else if(amazonprice>flipkartprice && flipkartdelivery>amazondelivery)
//		{
//			System.out.println("Amazon can deliver the fast");
//			//launch Amazon
//		}
//		else if(flipkartprice>amazonprice && amazondelivery>flipkartdelivery)
//		{
//			System.out.println("Flipkart delivers fastly");
//			//launch flipkart
//		}
//			
		
		
		
				
	}
}
