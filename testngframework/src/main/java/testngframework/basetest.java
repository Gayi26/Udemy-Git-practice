package testngframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
    protected WebDriver driver;
    landingpage landing;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\testngframework\\globaldata.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browserName + "\" not supported.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    
@BeforeMethod(alwaysRun=true)
    public landingpage launchApplication() throws IOException {
        driver = initializeDriver();
       landing = new landingpage(driver);
        landing.url();
       // landing.loginApplication("jennie123@gmail.com", "Jennie123");
        return landing;
    }
@AfterMethod(alwaysRun=true)
public void close()
{
	driver.close();
}
}
