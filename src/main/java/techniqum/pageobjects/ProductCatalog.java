package techniqum.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techniqum.abstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents{
	
	WebDriver driver;
	String productName = "ZARA COAT 3";
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// List<WebElement> cards = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> cards;
	
	//By.cssSelector(".ng-animating")
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By prodBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductsList()
	{
		waitUntilElementAppears(prodBy);
		return cards;
	}
	
	public WebElement getProductByName(String ProdName)
	{
		WebElement product = getProductsList().stream().filter(p->p.findElement(By.cssSelector("b"))
				.getText().equals(ProdName)).findFirst().orElse(null);
		
		return product;
	}
	
	public void addProductToCart(String ProdName)
	{
		WebElement prod = getProductByName(ProdName);
				prod.findElement(addToCart).click();
				waitUntilElementAppears(toastMessage);
				
				waitUntilElementDisappears(spinner);
	
	}
}
