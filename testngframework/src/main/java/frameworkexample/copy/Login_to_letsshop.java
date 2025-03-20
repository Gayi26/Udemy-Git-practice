package frameworkexample.copy;

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

public class Login_to_letsshop {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		landingpage2 page=new landingpage2(driver);
		driver.manage().window().maximize();
		String Product="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("jennie123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jennie123");
		driver.findElement(By.id("login")).click();
		 List<WebElement> allproducts = driver.findElements(By.xpath("//div[contains(@class,\"mb-3 ng-star\")]"));
		WebElement prod= allproducts.stream().filter(product->product.findElement(By.tagName("b")).getText().contains(Product)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		WebElement ele=driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"));
		boolean res=ele.isDisplayed();
		System.out.println(res);
		wait.until(ExpectedConditions.invisibilityOf(ele));
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();
		List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(Product));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,\"list-group ng-star-inserted\")]")));
		driver.findElement(By.xpath("//span[text()=' India']")).click();
		WebElement placeorder=driver.findElement(By.xpath("//a[text()='Place Order ']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);
		wait.until(ExpectedConditions.elementToBeClickable(placeorder));
		js.executeScript("arguments[0].click()",placeorder);
		//placeorder.click();
		WebElement thankyou=driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]"));
		String message=thankyou.getText();
		Assert.assertEquals(message,"THANKYOU FOR THE ORDER.");
		
	}

	
}
