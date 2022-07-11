package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.BaseClass;
import pojo.Browser;

@Listeners(test.Listeners.class)

public class TestListenres extends BaseClass{

	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chromeBrowser("https://www.facebook.com/");
	}
	@Test(timeOut = 1000)
	public void testOne() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Michael");
	}
	@Test (timeOut = 2000)
	public void testTwo() throws InterruptedException {
		Thread.sleep(3000);
		
	}
}
