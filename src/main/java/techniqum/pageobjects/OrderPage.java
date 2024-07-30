package techniqum.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import techniqum.abstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
	}
	
	@FindBy(css="..ng-star-inserted tr:nth-child(1) td:nth-child(3)")
	WebElement orderName;
	
	@FindBy(css=".ng-star-inserted  td:nth-child(3)")
	List<WebElement> orderProducts;
	
	
	//
	
	public Boolean VerifyOrderDisplays(String productName) {
		Boolean match =orderProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		
		 return match;
	}
	
	
	public Boolean VerifyProductDisplay(String productName) {
		System.out.println(orderName.getText());
		Boolean match =orderName.getText().equalsIgnoreCase(productName);
		
		 return match;
		
	}

}
