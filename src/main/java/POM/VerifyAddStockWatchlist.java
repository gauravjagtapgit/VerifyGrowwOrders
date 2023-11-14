package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility.UtilityClassForWaits;

public class VerifyAddStockWatchlist {
	WebDriver driver;
	
	@FindBy(xpath  = "(//span[@class='contentAccent swlc46CreateWatchlistText bodyMedium16'])[1]")
	private WebElement CreatNewWachlist;
	
	@FindBy(css = "input[placeholder='Enter name']")
	private WebElement EnterNamePopUp ;
	
	@FindBy(css = "span[class=\"absolute-center\"] span")
	private WebElement CreatButn ;
	
	public VerifyAddStockWatchlist(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void SelectNewWachlist() {
		WebElement ClickOnBtn = UtilityClassForWaits.WaitForVisiblityofElement(driver,CreatNewWachlist);
		ClickOnBtn.click();
		Reporter.log("click on creat new chatchlist button");
	}
	
	public void EnterStockNameFiled() {
		WebElement SendText = UtilityClassForWaits.WaitForVisiblityofElement(driver,EnterNamePopUp);
		SendText.click();
	}
	
	public void CreatBtn() {
		WebElement ClickOnBtn = UtilityClassForWaits.WaitForVisiblityofElement(driver,CreatButn);
		ClickOnBtn.click();
	}

}
