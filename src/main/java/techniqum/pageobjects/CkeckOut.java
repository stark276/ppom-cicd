package techniqum.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techniqum.abstractComponents.AbstractComponents;

public class CkeckOut extends AbstractComponents{
	
	WebDriver driver;
	
	public CkeckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	WebElement countryField = driver.findElement(By.cssSelector(".form-group input"));
	
	@FindBy(css=".form-group input")
	WebElement countryField;
	
	@FindBy(css=".ta-item:first-of-type")
	WebElement countryName;
	
	
//	driver.findElement(By.cssSelector(".ta-item:first-of-type")).click();
	
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
//	driver.findElement(By.cssSelector(".action__submit")).click();
	
	
	
	
	public Receipt fillCountryField(String value) {
        countryField.sendKeys(value);
        countryName.click();
        submitButton.click();
        Receipt receiptOrder = new Receipt(driver);
        return receiptOrder;
        
        
    }

}
