package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import POM.VerifyAddStockWatchlist;

public class VerifyUserCanAddStockWatchlist {
	
 WebDriver driver;
	
   VerifyAddStockWatchlist addstock;
	
	@BeforeClass
	@Parameters("browser")
	//public void beforclass(String browser) throws IOException {
	public void beforeClass(@Optional("chrome") String browser) throws IOException {
		
   driver =	BaseClass.getdriver(browser);	
	}
	@BeforeMethod
	public void beforemethod() {
		addstock =new VerifyAddStockWatchlist(driver);
	}
	@Test
	public void VerifyStocksAddWachlist() {
		addstock.SelectNewWachlist();
		addstock.EnterStockNameFiled();
		addstock.CreatBtn();
	}
	
}



