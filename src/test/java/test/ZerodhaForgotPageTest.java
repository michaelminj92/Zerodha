package test;



import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaForgotPage;

import utility.Excel;

public class ZerodhaForgotPageTest {

	WebDriver driver;
	
	@BeforeMethod 
	public void openBrowser() throws InterruptedException {
		driver = Browser.chromeBrowser("https://kite.zerodha.com/");
		ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
		zerodhaForgotPage.clickOnForgot();
	}
	
	@Test
	public void forgotPage() throws EncryptedDocumentException, InterruptedException, IOException{
		ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
	    Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
       
        String handle1 = i.next();
        System.out.println(handle1);
         driver.switchTo().window(handle1);
        
		String userId = Excel.getData("MichaelWorkbook",1,1);
		String pan = Excel.getData("MichaelWorkbook",4,1);
		String email = Excel.getData("MichaelWorkbook",5,1);
		zerodhaForgotPage.enterUserId(userId);
		zerodhaForgotPage.enterPan(pan);
		zerodhaForgotPage.enterEmail(email);
		
//		Actions action = new Actions(driver);
//		action.dragAndDrop(image,captcha);
//		action.perform();
    
		zerodhaForgotPage.clickOnReset(driver);	// 500 millis of interval;	
	}
}
