package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import POM.SellZomatoStockLimitPriceNSEOrder;

public class VerifySellZomatoStockDeliveryOrderNSEWithStockNotBuy {
	
	WebDriver driver;
	SellZomatoStockLimitPriceNSEOrder sp;
	
	@BeforeClass
	@Parameters("browser")
	public void BeforMethod(@Optional("chrome")String browser) throws IOException {
		driver=BaseClass.getdriver(browser);
	}
	
	@BeforeMethod
	public void beforemethod() {
	 sp = new SellZomatoStockLimitPriceNSEOrder(driver);
	}
	@Test
	public void testSellZomatoStock() {
        sp.SerchStock();
        sp.SelectSellOption();
        sp.QuantityOfStock();
        sp.SetLimitPrice();
      
        // 1. Verify that the "Sell" option is selected
        Assert.assertTrue(sp.SellOption.isSelected(), "Sell option is not selected");

        // 2. Verify the quantity entered
        Assert.assertEquals(sp.QatyForNSE.getAttribute("value"), "2", "Quantity is not as expected");

        // 3. Verify the limit price entered
        Assert.assertEquals(sp.LimitPrice.getAttribute("value"), "50", "Limit price is not as expected");

        // 4. Verify the stock not available message is displayed
        Assert.assertTrue(sp.StockNotAvailable(), "Stock not available message is not displayed");
    }
	@AfterClass
	public void teardown() {
		driver.close();
	}	

}
