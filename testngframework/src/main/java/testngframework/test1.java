package testngframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test1 extends basetest {

    @Test(dataProvider = "getData", groups = {"purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
        landing.loginApplication(input.get("email"), input.get("password"));
        productcatalogue catalogue = new productcatalogue(driver);
        List<WebElement> products = catalogue.getproductlist();
        boolean productFound = false;
        for (int i = 0; i < products.size(); i++) {
            WebElement productElement = products.get(i);
            String productName = productElement.findElement(By.cssSelector(".card-body b")).getText();
            System.out.println(productName);
            if (productName.equals("ZARA COAT 3")) {
                productElement.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
                productFound = true;
                break;
            }
        }
        if (productFound) {
            Addtocart add = new Addtocart(driver);
            add.adding();
            List<WebElement> cartItems = add.items();
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
        checkout co = new checkout(driver);
        co.checkout();
        placingorder po = new placingorder(driver);
        po.placingorder();
    }

    @Test(dependsOnMethods = "submitOrder")
    public void orderspage() throws InterruptedException {
        landing.loginApplication("jennie123@gmail.com", "Jennie123");
        orderspage op = new orderspage(driver);
        op.orders();
    }

    public void getScreenshot(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        java.io.File source = ts.getScreenshotAs(OutputType.FILE);
        java.io.File dest = new java.io.File(System.getProperty("user.dir") + "//reports//" + screenshotName + ".png");
        FileUtils.copyFile(source, dest);
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("email", "jennie123@gmail.com");
        map.put("password", "Jennie123");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "shambhavi@gmail.com");
        map1.put("password", "Shambhavi@123");

        return new Object[][] {
            {map},
            {map1}
        };
    }
}
