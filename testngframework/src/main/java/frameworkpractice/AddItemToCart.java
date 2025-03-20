package frameworkpractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemToCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("jennie123@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Jennie123");
        driver.findElement(By.id("login")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
        products.stream().filter(product -> product.findElement(By.xpath(".//b")).getText().equalsIgnoreCase("qwerty")).findFirst().ifPresent(product -> product.findElement(By.xpath(".//button[contains(text(),'Add To Cart')]")).click());

       // driver.quit();
    }
}
