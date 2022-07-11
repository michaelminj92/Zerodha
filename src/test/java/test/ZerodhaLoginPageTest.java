package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import utility.Excel;
import utility.ScreenShot;

public class ZerodhaLoginPageTest {

	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser () {
		driver = Browser.chromeBrowser("https://kite.zerodha.com/");
	}
	
	@AfterMethod(enabled = false)
	public void snippet() throws IOException {
	ScreenShot.takeScreenShot(driver,"Kite");

	}
	
	@Test
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		
		String userId = Excel.getData("MichaelWorkbook", 1, 1);
		String password = Excel.getData("MichaelWorkbook", 2, 1);
		String pin = Excel.getData("MichaelWorkbook", 3, 1);
		zerodhaLoginPage.enterUserId(userId);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(3000);
		zerodhaLoginPage.enterPin(driver,pin);
		zerodhaLoginPage.enterCaptcha(driver);
		zerodhaLoginPage.clickOnSubmit();
		
	}
}
