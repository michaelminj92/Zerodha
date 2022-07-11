package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaHomePageTest {

WebDriver driver;
    
	@BeforeMethod
	public void openBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver = Browser.chromeBrowser("https://kite.zerodha.com/");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String user = Excel.getData("MichaelWorkbook", 1, 1);
		String pass = Excel.getData("MichaelWorkbook", 2, 1);
		String pin = Excel.getData("MichaelWorkbook", 3, 1);
		
		zerodhaLoginPage.enterUserId(user);
		zerodhaLoginPage.enterPassword(pass);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		zerodhaLoginPage.enterPin(driver,pin);
		
		zerodhaLoginPage.clickOnSubmit();
		driver.manage().window().maximize();
	}
	
	@Test
	public void buyStocks() throws InterruptedException{
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		Thread.sleep(3000);
		zerodhaHomePage.clickOnSearchField(driver);
		zerodhaHomePage.enterCaptcha(driver);
	}
}
