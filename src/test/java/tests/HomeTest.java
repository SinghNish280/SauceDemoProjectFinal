package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseClass {
	
	
	//WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Test(groups={"Regression", "Master"})
    public void testAddItemToCart() {
    	
//    	String username= System.getenv("APP_USERNAME");
//		String password= System.getenv("APP_PASSWORD");
		LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
       
    

        homePage = new HomePage(driver);
        homePage.addItemToCart();
        homePage.goToCart();
        // Add assertions to verify item is in the cart
    }

   
}
