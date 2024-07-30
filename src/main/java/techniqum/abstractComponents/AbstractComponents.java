package techniqum.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import techniqum.pageobjects.CartPage;
import techniqum.pageobjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;



	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartIcon;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersIcon;
	
	
	
	
	public void waitUntilElementAppears(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitUntilElementAppears(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitUntilElementDisappears(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.invisibilityOf(findBy));
		
	}
	
	public CartPage goToCartPage() 
	{
		cartIcon.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() 
	{
		ordersIcon.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	

}
