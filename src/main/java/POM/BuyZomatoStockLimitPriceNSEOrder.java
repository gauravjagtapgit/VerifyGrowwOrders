package POM;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClassForWaits;

public class BuyZomatoStockLimitPriceNSEOrder {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='What are you looking for today?']")
	private WebElement serchbox;
	
	@FindBy(css = "input[id='inputShare']")
	private WebElement QtyForNSE;
	
	@FindBy(css = "input[id='limitPriceInput']")
	private WebElement PriceLimit;
	
	@FindBy(xpath = "//span[text()='BUY']")
	private WebElement BuyBtn;
	
	@FindBy(xpath = "//span[text()='ADD MONEY']")
	private WebElement AddMoney;
	
	public BuyZomatoStockLimitPriceNSEOrder(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void SerchStock() {
	WebElement SerchFiled=UtilityClassForWaits.WaitForpresenceOfElementLocated(driver,By.xpath("//input[@placeholder='What are you looking for today?']"));
	SerchFiled.sendKeys("Zomato");
	SerchFiled.sendKeys(Keys.ENTER);
	}
	
	public void QuantityOfStock() {
		WebElement EnterQuantity=UtilityClassForWaits.WaitForVisiblityofElement(driver, QtyForNSE);
		EnterQuantity.sendKeys("2");
	}
	
	public void SetPriceLimit() {
		PriceLimit.sendKeys("10");
	}
	
	public void BuyStock() {
		BuyBtn.click();
	}
	

}
