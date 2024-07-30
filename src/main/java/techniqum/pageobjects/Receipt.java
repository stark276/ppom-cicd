package techniqum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import techniqum.abstractComponents.AbstractComponents;

public class Receipt extends AbstractComponents{
	
	WebDriver driver;
	
	public Receipt(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	String messageConf = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement messageConfElement;
	
	String messageConf = messageConfElement.getText();
	
	public boolean confirmationOfMessage(String message) {
		Boolean match =messageConf.equalsIgnoreCase(message);
		 return match;
//		Assert.assertTrue(messageConf.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	
	

}
