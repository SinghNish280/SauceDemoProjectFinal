package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CheckoutComplete extends BasePage{
	
	public WebDriver driver;
	public String message;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
    WebElement cnfMessage;
	
	 public CheckoutComplete(WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
		 
		 super(driver);
	    }
	 
	 public String getCnfMessage() {
	    	message= cnfMessage.getText();
	    	 return message;
	    	
	    }

}
