package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		//location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		//loading properties file
		Properties propertiesobj = new Properties();
		propertiesobj.load(file);
		
		//reading data from properties file
		
		String url = propertiesobj.getProperty("appurl");
		String email = propertiesobj.getProperty("email");
		String pwd = propertiesobj.getProperty("password");
		String orid = propertiesobj.getProperty("orderid");
		String custid = propertiesobj.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+pwd+" "+orid+" "+custid);
		
		
		
	}

}
