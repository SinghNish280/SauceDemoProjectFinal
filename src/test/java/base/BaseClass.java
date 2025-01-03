package base;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public static WebDriver driver;
	 public Logger logger;
	 
	public String username= System.getenv("APP_USERNAME");
	public String password= System.getenv("APP_PASSWORD");
	 
    @BeforeClass(groups= {"Sanity","Regression", "Master"})
//    @Parameters({"os","browser"})
//    public void setUp(String os, String br) {
    	
    	public void setUp() {
    	
    	
    	logger=LogManager.getLogger(this.getClass());
    	WebDriverManager.chromedriver().setup();
    	//WebDriverManager.edgedriver().setup();
    	
//    	switch(br.toLowerCase()) {
//    	case "chrome" : driver = new ChromeDriver(); break;
//    	case "edge" : driver = new EdgeDriver(); break;
//    	case "firefox" : driver = new FirefoxDriver(); break;
//    	default: System.out.println("Invalid browser name..."); return;
//    	
//    	
//    	}
    	
    	
    	
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/v1/");
        
     // Retrieve the environment variable
       
    }

    @AfterClass(groups= {"Sanity","Regression", "Master"})
    public void tearDown() {
    driver.quit();
        
    }
    
    public String captureScreen(String tname) throws IOException  {
    	 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	 
    	 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    	 File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	 
    	 String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" +tname + "_" +timeStamp + ".png";
    	File targetFile = new File(targetFilePath);
    	 
    	 sourceFile.renameTo(targetFile);
    	 
    	 return targetFilePath;
    	
    	
    }
	

}
