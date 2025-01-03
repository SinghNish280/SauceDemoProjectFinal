package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleLogin {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");

        
        String filePath = "C:\\AutomationData\\DataswagLabs.xlsx";
        
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
        
        driver.quit();
        
	}

}
