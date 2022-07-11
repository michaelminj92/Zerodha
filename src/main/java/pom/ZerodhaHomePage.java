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

public class ZerodhaHomePage {
    

	@FindBy(xpath = "//input[@type='text']") private WebElement searchField;
	@FindBy(xpath = "(//li[@class='search-result-item'])[1]")private WebElement mandm;
	@FindBy(xpath = "(//button[@class='button-blue'])[1]") public WebElement buyButton;
	@FindBy(xpath = "(//button[@class='button-orange'])[1]") private WebElement sellButton;
	@FindBy(xpath = "(//button[@class='button-outline'])[1]") private WebElement chartButton;
	@FindBy(xpath = "(//button[@class='button-outline'])[2]") private WebElement marketDepthButtton;
	@FindBy(xpath = "//button[@class='button-green']") private WebElement addButton;
    @FindBy(xpath ="//img[contains(@src,'data:image/png;base64')]") private WebElement image;
    
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnSearchField(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(searchField);
		action.click();
		action.sendKeys("M&M");
		action.build().perform();
	    action.moveToElement(mandm);
	    action.perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(buyButton));
		action.moveToElement(buyButton);
		action.click();
		action.build().perform();
	}
		
public void enterCaptcha(WebDriver driver) {
		WebElement image = driver.findElement(By.xpath("//img[contains(@src,'data:image/png;base64')]"));
		String i = image.getText();
		System.out.println(i);
	}
	
}