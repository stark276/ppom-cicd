package techniqum.Selenium.tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;

import techniqum.Selenium.TestComponents.BaseTest;
import techniqum.Selenium.TestComponents.Retry;
import techniqum.pageobjects.CartPage;
import techniqum.pageobjects.CkeckOut;
import techniqum.pageobjects.ProductCatalog;
import techniqum.pageobjects.Receipt;

public class ErrorValidationsTest extends BaseTest{
	
	@Test(groups= {"Sanity"}, retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String user = "okaryb@gmail.com";
		String password = "kqa1erb_qdc7UPE-jab";
		
		
//		BaseTest base = new BaseTest();
		ProductCatalog productCatalog  = landingPage.loginApplication(user, password);
		String errorMess = landingPage.getMessage();
		Assert.assertEquals("Incorrect email or password.", errorMess);
		Thread.sleep(2000);
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		String productName = "ZARA COAT 3";
		String user = "kantokaryb@gmail.com";
		String password = "kqa1erb_qdc7UPE-jab";
		
//		BaseTest base = new BaseTest();
		ProductCatalog productCatalog  = landingPage.loginApplication(user, password);
		Thread.sleep(5000);
		List<WebElement> cards = productCatalog.getProductsList();
		productCatalog.addProductToCart(productName);
		Thread.sleep(3000);
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 34");
		Assert.assertFalse(match);
		Thread.sleep(3000);
		

	}
	
	@Test
	public void checkOutErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		String productName = "ZARA COAT 3";
		String user = "kantokaryb@gmail.com";
		String password = "kqa1erb_qdc7UPE-jab";
		
//		BaseTest base = new BaseTest();
		ProductCatalog productCatalog  = landingPage.loginApplication(user, password);
		List<WebElement> cards = productCatalog.getProductsList();
		productCatalog.addProductToCart(productName);
		Thread.sleep(3000);
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match =cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		Thread.sleep(3000);
		CkeckOut ckeckOut = cartPage.goToCheckOut();
		Receipt receipt = ckeckOut.fillCountryField("kyr");
		Thread.sleep(3000);		
		Boolean confirm = receipt.confirmationOfMessage("THANKYOU THE ORDER.");
		Assert.assertFalse(confirm);
		Thread.sleep(2000);
		

	}

}
