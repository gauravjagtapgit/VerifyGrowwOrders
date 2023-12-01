package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClassForWaits;

public class SellZomatoStockLimitPriceNSEOrder {
	
	WebDriver driver;
	
	@FindBy(css = "#globalSearch23")
	private WebElement SerchBox;
	
	@FindBy(xpath = "//div[text()='SELL']")
	public WebElement SellOption;
	
	@FindBy(css = "#inputShare")
	public WebElement QatyForNSE;
	
	@FindBy(css = "#limitPriceInput")
	public WebElement LimitPrice;
	
	@FindBy(css = "//div[text()='0 shares are available to sell']")
	private WebElement ShowMessage;
	
	public SellZomatoStockLimitPriceNSEOrder(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void SerchStock() {
	WebElement SerchZomatoStock =	UtilityClassForWaits.WaitForVisiblityofElement(driver, SerchBox);
	SerchZomatoStock.sendKeys("Zomato");
	SerchZomatoStock.sendKeys(Keys.ENTER);
	}
	
	public void SelectSellOption() {
		WebElement Sell =	UtilityClassForWaits.WaitForVisiblityofElement(driver, SellOption);
		Sell.click();
	}
	
	public void QuantityOfStock() {
		WebElement quantity =	UtilityClassForWaits.WaitForVisiblityofElement(driver, QatyForNSE);
		quantity.sendKeys("2");
	}
	
	public void SetLimitPrice() {
		LimitPrice.sendKeys("50");
	}
	
	public boolean StockNotAvailable() {
	    return ShowMessage.isDisplayed();
	}


}
