package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utils.DataProviders;

public class TC001_LoginDDT extends BaseClass {
	
  @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
  
  public void verify_loginDDT(String username, String password, String exp ) {
	  
	  logger.info("****** LoginTest started**********");
	  
	  try
	  {
	  
	  LoginPage loginPage = new LoginPage(driver);
      loginPage.login(username, password);
      
      logger.info("****** LoginTest Completed**********");
      //homepage
      
      logger.info("******Starting HomePageTest**********");
      HomePage homePage;
      homePage = new HomePage(driver);
     boolean targetpage=  homePage.isAppLogoPresent();
      
   if(exp.equalsIgnoreCase("Valid"))
   {
	   
	   if(targetpage==true)
	   {
		   homePage.clickOpenMenu();
		   homePage.clickLogout();
		   Assert.assertTrue(true);
		  
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
   }
      
   if(exp.equalsIgnoreCase("invalid"))
   {
	   
	   if(targetpage==true)
	   {
		   
		   homePage.clickLogout();
		   Assert.assertTrue(false);
	   }
	  
	   else
	   {
		   Assert.assertTrue(true);
	   }
  }
	  }
   
   catch(Exception e)
   {
	   
	  Assert.fail(); 
   }
	  
	  logger.info("****** Finished TC001_LoginDDT **********");
}

}