package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage{
	
	public WebDriver driver;

    @FindBy(xpath = "(//button[text()='ADD TO CART'])[1]")
    WebElement addToCartButton;
    
    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    WebElement cartIcon;
    
    @FindBy(xpath = "//button[text()='Open Menu']")
    WebElement Open_Menu;
    
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement lnk_logout;
    
  
    @FindBy(xpath = " //div[@class='app_logo']")
    WebElement applogoIcon;
    
    

    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
    	super(driver);
    }

    public void addItemToCart() {
        addToCartButton.click();
    }
    
    public void clickOpenMenu() {
    	Open_Menu.click();
    }
    
    public void clickLogout() {
    	lnk_logout.click();
    }

    public void goToCart() {
       cartIcon.click();
    }
    
    public boolean isAppLogoPresent() {
        try {
        	return(applogoIcon.isDisplayed());
        	
        }
        catch(Exception e) {
        	return false;
        }
     }
    
}


