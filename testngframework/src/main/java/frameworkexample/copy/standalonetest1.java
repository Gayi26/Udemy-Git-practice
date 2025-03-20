package frameworkexample.copy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class standalonetest1 extends baseclass {
    String Product = "ZARA COAT 3";
    
    @Test
    public void submitorder() throws IOException, InterruptedException {       
        String country = "India";
        
        // Launch application and get driver
        landingpage2 page = launchapplication(); 
        
        page.loggingIn("jennie123@gmail.com", "Jennie123");  
        
        // Initialize product catalog with correct driver
        productcatalogue3 pc = new productcatalogue3(driver); 
        List<WebElement> allproducts = pc.products();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean res = pc.addtocart(Product);
        System.out.println(res);		

        commonmethods4 cm = new commonmethods4(driver);
        cm.goToCart();
       
        cartpage5 cp = new cartpage5(driver);
        Boolean match = cp.cartproductsver(Product);
        Assert.assertTrue(match, "Product verification failed in cart.");

        cp.checkout();
        checkoutpage6 ch = new checkoutpage6(driver);
        ch.selectcountry(country);

        String message = ch.confirmmessage();		
        Assert.assertEquals(message, "THANKYOU FOR THE ORDER.", "Order confirmation message mismatch.");
    }

    @Test(dependsOnMethods = {"submitorder"})
    public void orderHistory() throws InterruptedException, IOException {
        landingpage2 page = launchapplication();

        page.loggingIn("jennie123@gmail.com", "Jennie123");	

        orderspage8 op = new orderspage8(driver);
        boolean res = op.productverification(Product);
        Assert.assertTrue(res, "Product verification in order history failed.");
    }

    public String getScreenshot(String testcasename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
        FileUtils.copyFile(source, dest);
        return dest.getAbsolutePath();
    }
}
