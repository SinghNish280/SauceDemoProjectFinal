package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtilDemo;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Multiple_Login {

	WebDriver driver;
	 String filePath = "C:\\AutomationData\\DataswagLabs.xlsx";
     

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/v1/");
	}

	@Test
	public void login() throws IOException, InterruptedException {
		
		 int rows= ExcelUtilDemo.getRowCount(filePath, "Sheet1");
		 
		 for(int i=1; i<=rows;i++) {
	        	
	        	//Read data from excel
	        	String username = ExcelUtilDemo.getCellData(filePath, "Sheet1", i, 0);
	        	String password = ExcelUtilDemo.getCellData(filePath, "Sheet1", i, 1);
	        	
	        	
	        	//pass above data into application
	        	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
	        	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	        	
	        	driver.findElement(By.xpath("//input[@id='login-button']")).click();
	        	
	        	
	        	driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	        	driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	        	
	        	Thread.sleep(3000);
	        }
	}

	@AfterClass
    public void tearDown() {
    driver.quit();
    
	}

}
