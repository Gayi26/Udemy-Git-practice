package testngframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
    WebDriver driver;

    public landingpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement useremail;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;
    @FindBy(xpath="//div[text()=' Incorrect email or password. ']")
    WebElement incorrectdetails;

    String url = "https://rahulshettyacademy.com/client";

    public void loginApplication(String username, String userpassword) {
        useremail.sendKeys(username);
        password.sendKeys(userpassword);
        submit.click();
    }
    public String invalidcredentials()
    {
    	return incorrectdetails.getText();
    }

    public void url() {
        driver.get(url);
    }
}
