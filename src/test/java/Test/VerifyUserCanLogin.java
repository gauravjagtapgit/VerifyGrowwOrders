package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.BaseClass;
import POM.BuyZomatoStockLimitPriceNSEOrder;
import POM.LoginPage;
import POM.SellZomatoStockLimitPriceNSEOrder;
import Utility.UtilityForScreenshots;

public class VerifyUserCanLogin{
	
	WebDriver driver;
	
	LoginPage lp;
	
	BuyZomatoStockLimitPriceNSEOrder buystock;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	SellZomatoStockLimitPriceNSEOrder sp;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(@Optional("chrome") String browser) throws IOException {
		
		htmlReporter = new ExtentHtmlReporter("ExtentReports.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		test = reports.createTest("VerifyUserCanLogin");
		
   driver =	BaseClass.getdriver(browser);	
	}
	
	@BeforeMethod
	public void beforemethod() {
	 lp =new LoginPage(driver);
	 buystock = new BuyZomatoStockLimitPriceNSEOrder(driver);
	 sp = new SellZomatoStockLimitPriceNSEOrder(driver);
	}
	
	@Test
	public void VerifyUserCanLogin() throws IOException {
		lp.ClickLoginRegisterBtn();
		lp.youremailaddress();
		lp.ContinueBtn();
		lp.EnterPassword();
		lp.Submit();
		
		 // Pause for manual OTP entry
        String otp = lp.waitForOTPInput();
        
     // Pause for manual PIN entry
        String pin = lp.waitForPINInput();
        
     // Enter OTP and PIN into the web page
        lp.enterOTP(otp);
        lp.enterPIN(pin);
		
		String expectedURL = "https://groww.in/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Login unsuccessful!");
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() +" is Passed");
		}
		
		
		
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			String path = UtilityForScreenshots.getScreenShotPath(driver, result.getName());
			
			test.log(Status.FAIL, result.getName() +" is Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		else if(result.getStatus() == ITestResult.SKIP){
			
			test.log(Status.FAIL, result.getName() +" is Skipped");
		}
		
	}
	
	@AfterClass
	public void afterClass() {
		
		reports.flush();
	
	}
}
