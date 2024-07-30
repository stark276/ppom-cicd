package techniqum.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techniqum.abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmails = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	//
	@FindBy(id="userPassword")
	WebElement Password;
	//
	@FindBy(id="login")
	WebElement submit;
	//
//	@FindBy(id="userEmail")
//	WebElement userEmail;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public ProductCatalog loginApplication(String email, String pass)
	{
		userEmail.sendKeys(email);
		Password.sendKeys(pass);
		submit.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	public String getMessage() {
		
		waitUntilElementAppears(errorMessage);
		return errorMessage.getText();
		
	}

	
}
