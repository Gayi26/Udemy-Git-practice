package testngframework;

import org.testng.annotations.Test;

import org.junit.Assert;

public class test3 extends basetest{
	@SuppressWarnings("restriction")
	@Test(groups= {"error validation"})
	public void error()
	{
        landing.loginApplication("jennie123@gmail.com", "Jennie");
        //Assert.assertEquals("  Incorrect email or password. ", landing.invalidcredentials());
	}

}
