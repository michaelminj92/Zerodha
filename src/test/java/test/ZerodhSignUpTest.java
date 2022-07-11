package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.ZerodhaSignUpPage;
import utility.Excel;


public class ZerodhSignUpTest{

	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = Browser.chromeBrowser("https://kite.zerodha.com");
		
		
	}
	@Test(timeOut=2000)
	public void signUp() throws EncryptedDocumentException, IOException, InterruptedException {
		
		ZerodhaSignUpPage zerodhaSignUpPage = new ZerodhaSignUpPage(driver);
		
		zerodhaSignUpPage.clickOnSignUp();	
		
		Set<String> handles = driver.getWindowHandles();
		Iterator <String> i = handles.iterator();
		
	    String handle1 = i.next();
	    System.out.println(handle1);
	    
	    String handle2 = i.next();
	    System.out.println(handle2);
		driver.switchTo().window(handle2);
		
		String moblieNo = Excel.getData("MichaelWorkbook",6,1);
		zerodhaSignUpPage.enterMobileNo(moblieNo);
		zerodhaSignUpPage.clickOnSubmit();
		
		
	}
	@Test
	public void testGitHub() {
		
	}
}
