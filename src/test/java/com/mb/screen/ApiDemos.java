package com.mb.screen;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mobilebaseclass.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;
import testData.TestData;

public class ApiDemos extends Base {
	@Test(dataProvider = "InputData",dataProviderClass = TestData.class)
	public void apisDemosTest(String input) throws InterruptedException, IOException 
	  {
		service=startServer();
		
		AndroidDriver<AndroidElement> driver=Capabilities("apisDemo");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		HomePage h=new HomePage(driver);
		Thread.sleep(1200);
		h.preferences.click();
		
		 
		Preferences p=new Preferences(driver);		
		p.dependencies.click();

		Thread.sleep(1200);
		
		Thread.sleep(1200);
		driver.findElement(By.id("android:id/checkbox")).click();
		Thread.sleep(1200);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		Thread.sleep(1200);

		driver.findElement(By.className("android.widget.EditText")).sendKeys(input);
		
		p.list.get(1).click();
		System.out.println("successfully clicked");
		
		//service.stop();
		

}}
