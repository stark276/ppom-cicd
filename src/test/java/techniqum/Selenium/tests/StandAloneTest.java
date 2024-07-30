package techniqum.Selenium.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import techniqum.Selenium.TestComponents.BaseTest;
import techniqum.pageobjects.CartPage;
import techniqum.pageobjects.CkeckOut;
import techniqum.pageobjects.OrderPage;
import techniqum.pageobjects.ProductCatalog;
import techniqum.pageobjects.Receipt;

public class StandAloneTest extends BaseTest{
	
	
	
	String filePath = "//src//test//java//techniqum//data//PurchaseOrder.json";
	
	@Test(dataProvider="getData", groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		BaseTest base = new BaseTest();
		ProductCatalog productCatalog  = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> cards = productCatalog.getProductsList();
		productCatalog.addProductToCart(input.get("product"));
		Thread.sleep(3000);
		CartPage cartPage = productCatalog.goToCartPage();
		Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		Thread.sleep(1000);
		CkeckOut ckeckOut = cartPage.goToCheckOut();
		Receipt receipt = ckeckOut.fillCountryField("kyr");
		Thread.sleep(1000);		
		Boolean confirm = receipt.confirmationOfMessage("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(confirm);
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData", groups="Purchase" )
	public void orderHistoryTest(HashMap<String,String> input) throws InterruptedException {
		
//		BaseTest base = new BaseTest();
		ProductCatalog productCatalog  = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		OrderPage orderPage = productCatalog.goToOrderPage();
		Thread.sleep(2000);
		Boolean verifyOrder = orderPage.VerifyOrderDisplays(input.get("product"));
		Thread.sleep(1000);
		Assert.assertTrue(verifyOrder);
		
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonDataTOMap(filePath);
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}


//HashMap<String, String> map = new HashMap<String, String>();
//
//map.put("email", "kaskhelmet22@gmail.com");
//map.put("password", "Kokokivi123");
//map.put("product", "ZARA COAT 3");
//
//HashMap<String, String> map1 = new HashMap<String, String>();
//
//map1.put("email", "kantokaryb@gmail.com");
//map1.put("password", "kqa1erb_qdc7UPE-jab");
//map1.put("product", "ADIDAS ORIGINAL");





