package stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import frameworkexample.copy.baseclass;
import frameworkexample.copy.cartpage5;
import frameworkexample.copy.checkoutpage6;
import frameworkexample.copy.commonmethods4;
import frameworkexample.copy.landingpage2;
import frameworkexample.copy.productcatalogue3;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinitionimplementation extends baseclass {
    
    public landingpage2 page;

    @Given("I landed on Ecommerce page")
    public void landonecommerce() throws IOException {
        page = launchapplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void loggedinusernameandpassword(String username, String password) throws IOException {
        page.loggingIn(username, password);
    }

    @When("^I add product (.+) to cart$")
    public void addproducttocart(String productname) throws InterruptedException {
        productcatalogue3 pc = new productcatalogue3(driver);
        
        List<WebElement> allproducts = pc.products();
        System.out.println("Total products found: " + allproducts.size()); // Debugging

//        if (allproducts.isEmpty()) {
//            System.out.println("No products found on the page.");
//            Assert.fail("No products found on the page.");
//        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean res = pc.addtocart(productname);

//        if (!res) {
//            System.out.println("Product '" + productname + "' not found in the list.");
//            Assert.fail("Product not added to cart.");
//        }
    }

    @When("^checkout (.+) and submit the order$")
    public void checkout(String productname) {
        commonmethods4 cm = new commonmethods4(driver);
        cm.goToCart();

        cartpage5 cp = new cartpage5(driver);
        Boolean match = cp.cartproductsver(productname);
        
        Assert.assertTrue(match, "Product verification failed in cart.");
        
        cp.checkout();
        checkoutpage6 ch = new checkoutpage6(driver);
        ch.selectcountry("india");
    }

    @Then("{string} message is displayed on confirmation page")
    public void confirmationpage(String expectedMessage) {
        checkoutpage6 ch = new checkoutpage6(driver);
        String actualMessage = ch.confirmmessage();
        
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message mismatch.");
    }
}
