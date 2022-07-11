package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	@FindBy (xpath="//input[@id='userid']") private WebElement userId;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//button[@type='submit']") private WebElement login;
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy (xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']") private WebElement submit;
	@FindBy(xpath ="//img[contains(@src,'data:image/png;base64')]") private WebElement image;
	
//	@FindBy (xpath = "(//input[@type ='text'])[1]") private WebElement userName;
//	@FindBy (xpath = "(//input[@type = 'text'])[2]") private WebElement pan;
//	@FindBy (xpath = "(//input[@type = 'text'])[3]") private WebElement email;
//	@FindBy (xpath = "//img[contains(@src,'data:image/png;base64')]")private WebElement image;
//	@FindBy (xpath = "(//input[@type = 'text'])[4]") private WebElement captcha;
//	@FindBy (xpath = "//button[@type='submit']") private WebElement reset;
	
	public ZerodhaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void enterUserId (String user) {
		userId.sendKeys(user);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLogin() {
		login.click();
	}
	public void clickOnForgot() {
		forgot.click();
	}
	public void clickOnSignUp() {
		signUp.click();
	}
    public void enterCaptcha(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOf(image));
    	WebElement img = driver.findElement(By.xpath("//img[contains(@src,'data:image/png;base64')]"));
    	String i = img.getText();
    	System.out.println(i);

     }
    public void clickOnSubmit() {
    	submit.click();
    }
    public void enterPin(WebDriver driver , String pinnum) {
    	WebDriverWait wait = new WebDriverWait(driver , Duration.ofMillis(3000));
    	wait.until(ExpectedConditions.visibilityOf(pin));
    	pin.sendKeys(pinnum);
    }
}
