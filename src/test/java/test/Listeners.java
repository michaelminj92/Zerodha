package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import pojo.BaseClass;
import utility.ScreenShot;

public class Listeners extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+"Test has Started");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+"Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		try {
			ScreenShot.takeScreenShot(driver,result.getName());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
