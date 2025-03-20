package frameworkexample.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testngframework.commonmethods;

public class productcatalogue3 extends commonmethods4{
	//WebDriver driver = initilizedriver();

	public productcatalogue3(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,\"mb-3 ng-star\")]")
	List<WebElement> allproducts;
	@FindBy(xpath="//div[text()=' Product Added To Cart ']")
	WebElement addtocarttoastermessage;
	By addtocart=By.xpath("//button[text()=' Add To Cart']");
	By toaster=By.id("toast-container");
	public List<WebElement> products(){
		return allproducts;
	}
	public WebElement getproduct(String Product)
	{
		WebElement prod= products().stream().filter(product->product.findElement(By.tagName("b")).getText().contains(Product)).findFirst().orElse(null);
		System.out.println(prod);
		return prod;

	}
	public boolean addtocart(String Product) throws InterruptedException
	{
		WebElement prod=getproduct(Product);
		System.out.println(prod);
		prod.findElement(addtocart).click();
		elementVisible(toaster);
		boolean res=addtocarttoastermessage.isDisplayed();
		elementInvisible(addtocarttoastermessage);
		return res;		
	}
	
	
}
