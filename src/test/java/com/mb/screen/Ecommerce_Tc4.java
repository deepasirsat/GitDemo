package com.mb.screen;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobilebaseclass.Base;
import com.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;

public class Ecommerce_Tc4 extends Base {
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		 Runtime.getRuntime().exec("src\\main\\resources\\startEmulator.bat");
         Thread.sleep(6000);
         service=startServer();
	}
  @Test
  public void totalvalidationTest() throws IOException, InterruptedException
      { 
	 
	  
	   AndroidDriver<AndroidElement> driver=Capabilities("GenralStoreApp");
	   FormPage f=new FormPage(driver);
	   CheckOutPage c=new CheckOutPage(driver);
	  
	  
	   f.getNameField().sendKeys("Deepa");  
	   driver.hideKeyboard();
	   f.femaleOption.click();
	   
	   f.countryName.click(); 
	   
	   
	   Utilities u=new Utilities(driver);
	   u.scrollToText("Brazil");
	   f.countryName1.click();
	   f.letsShop.click();
	   f.product1.get(0).click();
	   f.product2.get(0).click();
	   f.basketButton.click();
       Thread.sleep(4000);
       String amount1 =c.productPrice1.get(0).getText();
      //$160.97
       amount1=amount1.substring(1);
       //160.97
       String amount2 =c.productPrice2.get(1).getText();
      //$120.0
       amount2=amount2.substring(1);
  
       //120.0
       float amount1Value=Float.parseFloat(amount1);
       float amount2Value=Float.parseFloat(amount2);
       float sumOfproducts=amount1Value+amount2Value;
       System.out.println(sumOfproducts);
       String total=c.totalPurchaseAmount.getText();
       total=total.substring(1);
       float totalValue=Float.parseFloat(total);
       System.out.println(totalValue);
       Assert.assertEquals(sumOfproducts, totalValue);
       
       //service.stop();
       
       

       
}}

