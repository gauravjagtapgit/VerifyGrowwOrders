package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.UtilityClassForProperties;
import Utility.UtilityClassForWaits;

import java.util.Scanner;
public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Login/Register']")
    private WebElement LoginRegisterBtn;

    @FindBy(xpath = "//input[@id='login_email1']")
    private WebElement EnterEmailId;

    @FindBy(xpath = "(//div[@class='absolute-center btn51ParentDimension'])[1]")
	private WebElement ContinueBtn;
    
    @FindBy(xpath = "//input[@id='login_password1']")
    private WebElement EnterPassword;
    
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement AgainClick;
    
    @FindBy(xpath = "(//input[@autocomplete='new-password'])[1]")
    private WebElement PINInputElement;
    
    @FindBy(xpath = "(//input[@autocomplete='new-password'])[1]")
    private WebElement OTPInputElement;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void ClickLoginRegisterBtn() {
		WebElement ClickOnBtn = UtilityClassForWaits.WaitForVisiblityofElement(driver,LoginRegisterBtn);
		ClickOnBtn.click();
	}
	
	public void youremailaddress() throws IOException {
		UtilityClassForWaits.WaitForVisiblityofElement(driver,EnterEmailId);
		String EnterMailId =UtilityClassForProperties.getproperties("mailId");
		if (EnterMailId != null && !EnterMailId.isEmpty()) {
			EnterEmailId.sendKeys(EnterMailId);
	    }
	}
	
	public void ContinueBtn() {
		WebElement Continue = UtilityClassForWaits.WaitForVisiblityofElement(driver,ContinueBtn);
		Continue.click();
	}
	
	public void EnterPassword() throws IOException {
		UtilityClassForWaits.WaitForVisiblityofElement(driver,EnterPassword);
		String Password =UtilityClassForProperties.getproperties("password");
		if (Password != null && !Password.isEmpty()) {
			EnterPassword.sendKeys(Password);
	    }
	}
	
	public void Submit() {
		WebElement submit = UtilityClassForWaits.WaitForVisiblityofElement(driver,AgainClick);
		submit.click();
	}
	public String waitForOTPInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        return scanner.nextLine();
    }
	// Add this method for manual PIN entry
    public String waitForPINInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        return scanner.nextLine();
    }

    // Updated method to enter OTP
    public void enterOTP(String otp) {
    	
        UtilityClassForWaits.WaitForVisiblityofElement(driver, OTPInputElement).sendKeys(otp);
    }

    // Updated method to enter PIN
    public void enterPIN(String pin) {
        UtilityClassForWaits.WaitForVisiblityofElement(driver, PINInputElement).sendKeys(pin);
    }
    
}
