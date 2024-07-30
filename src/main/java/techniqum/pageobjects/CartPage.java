package techniqum.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import techniqum.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[contains(text(), 'Checkout')]")
	WebElement checkout;
	
	
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match =cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		
		 return match;
		
	}
	
	public CkeckOut goToCheckOut() {
		checkout.click();
		CkeckOut checkout = new CkeckOut(driver);
		return checkout;
		
		
	}
	
//	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//	
//	List<String> choosenProduct = cartProducts.stream().filter(s->s.getText().equalsIgnoreCase(productName)).map(WebElement::getText)
//			.collect(Collectors.toList());
//	Boolean match =cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
//	
//	Assert.assertTrue(match);
	
	
	
	

}
