package com.mobilebaseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AndroidDriver<AndroidElement> driver;
	static String path=System.getProperty("user.dir");
	static Properties pro=new Properties();
	
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}


       public static void startEmulator() throws IOException, InterruptedException
         { Runtime.getRuntime().exec("src\\main\\resources\\startEmulator.bat");
           Thread.sleep(6000);
	
        }
	
	public static AndroidDriver<AndroidElement> Capabilities(String appName ) throws IOException, InterruptedException
	{   
		
		
		File f=new File("src\\test\\resources\\properties\\global.properties");
		
		FileInputStream fis=new FileInputStream(f);
	    pro.load(fis);
	    File appDir=new File("lib");
		File app=new File(appDir,pro.getProperty(appName));
		System.out.println(appName);
		DesiredCapabilities capabilities=new DesiredCapabilities();
		String device=(String) pro.get("device");
		if(device.contains("Emulator"))
		{
			startEmulator();
			Thread.sleep(6000);
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("app open successfully");
	    return driver;
	}
	public  static void  getScreenShot(String s) throws IOException
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+s+".png"));
	}
	
	

}
