package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import POM.BuyZomatoStockLimitPriceNSEOrder;

public class VerifyBuyZomatoStockDeliveryOrderNSE {
	
	WebDriver driver;
	BuyZomatoStockLimitPriceNSEOrder buystock;
	
	@BeforeClass
	@Parameters("browser")
	public void beforclass(@Optional("chrome") String browser) throws IOException {
		driver=BaseClass.getdriver(browser);
	}
	
	@BeforeMethod
	public void beformethod() {
		
	 buystock=new BuyZomatoStockLimitPriceNSEOrder(driver);
	 
	}
	
	@Test
	public void VerifyZomatoStockserch() {
		buystock.SerchStock();
	  WebElement SerchFiled=driver.findElement(By.xpath("//input[@placeholder='What are you looking for today?']\""));
		Assert.assertTrue(SerchFiled.isDisplayed(), "Search result is displayed");
	}
    
	@Test
	public void BuyStockInLimitPrice() {
		buystock.QuantityOfStock();
		buystock.SetPriceLimit();
		buystock.BuyStock();
		
		 WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage")); // Replace with actual ID
	        Assert.assertTrue(confirmationMessage.isDisplayed(), "Buy stock confirmation message is displayed");
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
