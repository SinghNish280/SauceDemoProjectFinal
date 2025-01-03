package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.CheckoutComplete;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest extends BaseClass {
	
	
	@Test(groups={"Sanity","Master"})
    public void loginTest() throws InterruptedException {
		
		
//		String username= System.getenv("APP_USERNAME");
//		String password= System.getenv("APP_PASSWORD");
//		String filePath= "C:\\AutomationData\\DataswagLabs.xlsx";
//		String sheetName = "Sheet1";
       
		logger.info("******Starting LoginTest**********");
		
		try {
			
			
		
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        
        logger.info("****** LoginTest Completed**********");
        //homepage
        
        logger.info("******Starting HomePageTest**********");
        HomePage homePage;
        homePage = new HomePage(driver);
        homePage.addItemToCart();
        homePage.goToCart();
        
        logger.info("****** HomePageTest Completed**********");
        
        
        logger.info("******Starting CartTest**********");
        CartPage cartpage= new CartPage(driver);
        cartpage.clickCheckout();
        
        logger.info("****** CartTest Completed**********");
        
        logger.info("******Starting CheckoutTest**********");
        CheckoutPage cp= new CheckoutPage(driver);
        cp.enterFirstName("Nishant");
        cp.enterLastName("Singh");
        cp.enterPostalCode("12345");
        cp.clickContinue();
        cp.clickFinish();
        
        
        logger.info("****** CheckoutTest Completed**********");
        
        CheckoutComplete cc= new CheckoutComplete(driver);
        cc.getCnfMessage();
        System.out.println(cc.message);
        Thread.sleep(3000);
        
		}
		
		catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
    }
	
	
	


}
