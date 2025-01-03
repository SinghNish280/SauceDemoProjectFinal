package listenersDemo;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//@Listeners(listenersDemo.MyListerner.class)

public class SauceLabsTest {

	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://www.saucedemo.com/v1/");
      Thread.sleep(3000);
  }
  
  @Test(priority=1)
  public void testLogo() {
	  
	  boolean status = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
	  Assert.assertEquals(status, true);
  }
  
  @Test(priority=2)
  public void testAppUrl() {
	  
	  
	  Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/h4");
  }
  
  @Test(priority=3, dependsOnMethods= {"testAppUrl"})
  //@Test(priority=3)
  public void testPageTitle() {
	  
	  
	  Assert.assertEquals(driver.getTitle(), "Swag Labs");
  }


  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }

}
