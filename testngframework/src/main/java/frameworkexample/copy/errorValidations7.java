package frameworkexample.copy;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class errorValidations7 extends baseclass {

//    @Test
//    public void submitOrder() throws IOException, InterruptedException { 
//        landingpage2 page = launchapplication(); 
//        page.loggingIn("jennie123@gmail.com", "Jennie1");
//       // Assert.assertEquals(page.invalidData(), "Incorrect email or password.");
//        Assert.assertEquals(page.invalidData(), "Incorrect email password.");
//    }

    @Test(retryAnalyzer=Retry.class)
    public void submitOrder() throws IOException, InterruptedException { 
        landingpage2 page = launchapplication(); 
        page.loggingIn("jennie123@gmail.com", "Jennie1");
       // Assert.assertEquals(page.invalidData(), "Incorrect email or password.");
        Assert.assertEquals(page.invalidData(), "Incorrect email password.");
    }
}
