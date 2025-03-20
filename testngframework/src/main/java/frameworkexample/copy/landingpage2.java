package frameworkexample.copy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage2 extends commonmethods4 {

    public landingpage2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement useremail;

    @FindBy(id = "userPassword")
    WebElement userpassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(xpath = "//div[@aria-label=\"Incorrect email or password.\"]")
    WebElement invalidCredentials;

    public void navigate() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public void loggingIn(String email, String password) {
        useremail.sendKeys(email);
        userpassword.sendKeys(password);
        login.click();
    }

    public String invalidData() {
        return invalidCredentials.getText();
    }
}
