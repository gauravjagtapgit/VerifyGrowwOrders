package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.UtilityClassForProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	


public static WebDriver getdriver(String browser) throws IOException {
	
	if(driver==null) {
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			 driver= new ChromeDriver();
		}
		else if (browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}
		
		driver.get(UtilityClassForProperties.getproperties("url"));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;
		
	}
	public static void unloadDriver() {
		driver=null;
	}

}
