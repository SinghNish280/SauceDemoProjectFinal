package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CheckoutPage extends BasePage{

	public WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;
    
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;
    
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCode;
    
    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    WebElement continueButton;
    
    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    WebElement finishButton;
    
    
    
    
    

    public CheckoutPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
    	
    	super(driver);
    }

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterPostalCode(String pcode) {
        postalCode.sendKeys(pcode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }
    
    
}
