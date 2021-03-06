package com.caw.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.caw.qa.util.TestUtil;
import com.caw.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
	
	public TestBase() {			
		try {
		prop =new Properties();
		FileInputStream ip=new FileInputStream("/home/nikhilk/eclipse-workspace/CawTest/src/main/java/com/caw/qa/config/config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void intialization() {
		String browsername =prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver","/home/nikhilk/Desktop/Seleniumjar/chromedriver");
			driver =new ChromeDriver();
																																																																																																																																								
		}else if(browsername.equals("Firefox")){
			
			//System.setProperty("webdriver.gecko.driver","/home/nikhilk/Desktop/Seleniumjar/chromedriver");
			driver =new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
	    e_driver.register(eventListener);
		driver = e_driver;
        driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("UATurl"));
		
		}
	

}
