package frameworkexample.copy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonmethods4 {
    WebDriver driver;

    public commonmethods4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[contains(text(),'Cart')])[1]")
    WebElement cartButton;

    public void elementVisible(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void elementClickable(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void elementInvisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public void goToCart() {
        if (cartButton == null) {
            System.out.println("Error: cartButton is not initialized.");
            return;
        }
        elementClickable(By.xpath("(//button[contains(text(),'Cart')])[1]")); // Ensure it's clickable
        cartButton.click();
    }
}
