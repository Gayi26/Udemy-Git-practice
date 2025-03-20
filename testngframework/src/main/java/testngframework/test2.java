package testngframework;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
public class test2 {
    	public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // increased wait duration for better reliability
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("jennie123@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Jennie123");
        driver.findElement(By.id("login")).click();
        landingpage landing=new landingpage(driver);
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
        boolean productFound = false;
        for (int i = 1; i <= products.size(); i++) {
            String productname = driver.findElement(By.xpath("(//div[@class='card-body']/..//b)[" + i + "]")).getText();
            System.out.println(productname);
            if (productname.equals("ZARA COAT 3")) {
                WebElement addToCartButton = driver.findElement(By.xpath("(//div[@class='card-body'])[" + i + "]//button[contains(text(),'Add To Cart')]"));
                addToCartButton.click();
                productFound = true;
                break;
            }
        }
        if (productFound) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"))));
            driver.findElement(By.xpath("//button[contains(text(),'Cart')]")).click();
            List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
            boolean itemInCart = false;
            for (WebElement item : cartItems) {
                String itemName = item.getText();
                System.out.println("Cart item: " + itemName);
                if (itemName.equals("ZARA COAT 3")) {
                    itemInCart = true;
                    break;
                }
            }
            if (itemInCart) {
                System.out.println("ZARA COAT 3 has been successfully added to the cart.");
            } else {
                System.out.println("ZARA COAT 3 was not found in the cart.");
            }
        } else {
            System.out.println("ZARA COAT 3 was not found in the product list.");
        }
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        WebElement ele=driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]"));
        wait.until(ExpectedConditions.visibilityOf(ele));
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")), "India").build().perform();
        driver.findElement(By.xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]/..//span[text()=' India']")).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement placeorder=driver.findElement(By.xpath("//a[text()='Place Order ']"));
		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Place Order ']")));
		 Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"actions\"]/..//a[@class=\"btnn action__submit ng-star-inserted\"]")).click();
        String confirmmessage=driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
        Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.quit();
    }
}
