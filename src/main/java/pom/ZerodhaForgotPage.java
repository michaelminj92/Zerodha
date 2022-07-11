package pom;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaForgotPage {
	
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "(//input[@type ='text'])[1]") private WebElement userId;
	@FindBy (xpath = "(//input[@type = 'text'])[2]") private WebElement pan;
	@FindBy (xpath = "(//input[@type = 'text'])[3]") private WebElement email;
	@FindBy (xpath = "(//div[@value='STVZmOt03q6ByBIV9TjQ:']") private static WebElement image;
	@FindBy (xpath = "(//input[@type = 'text'])[4]") private WebElement captcha;
	@FindBy (xpath = "//button[@type='submit']") private WebElement reset;
	
	@FindBy (xpath= "//input[@id='user_mobile']") private WebElement mobileNo;
    @FindBy (xpath = "//button[@id='open_account_proceed_form']") private WebElement submit;
    
    
	public ZerodhaForgotPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnForgot() {
		forgot.click();
	}
	
	public void enterUserId(String user) {
		userId.sendKeys(user);
	}
	public void enterPan(String num) {
		pan.sendKeys(num);
	}
	public void enterEmail(String id) {
		email.sendKeys(id);
	}
    public void clickOnReset(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
    	wait.until(ExpectedConditions.visibilityOf(submit));
    	
    	reset.click();
    }
    public void dragImage(WebDriver driver) {
    	
		
		WebElement image = driver.findElement(By.xpath("(//div[@value='STVZmOt03q6ByBIV9TjQ:']"));
		WebElement captcha = driver.findElement(By.xpath("(//input[@type = 'text'])[4]"));
		
		
		Actions action = new Actions(driver);
		action.dragAndDrop(image,captcha);
		action.perform();
    
    }	
}
