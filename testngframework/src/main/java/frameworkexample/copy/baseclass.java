package frameworkexample.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseclass {
	public WebDriver driver;
	
	public WebDriver initilizedriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//frameworkexample//copy//globaldata.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			 driver=new ChromeDriver();
					
		}
		else if(browsername.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browsername.equals("edge"))
		{
			 driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;		
	}
	
	public landingpage2 launchapplication() throws IOException
	{
		driver = initilizedriver();
		landingpage2 page=new landingpage2(driver);
		page.navigate();
		return page;
	}
	 public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
	        FileUtils.copyFile(source, dest);
	        return dest.getAbsolutePath();
	    }
	
	public void closebrowser()
	{
		//driver.close();
	}

}
