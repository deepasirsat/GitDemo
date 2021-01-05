package pageObjects;
//All the objects belonging to one page will be defined in java class

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	//is to call driver object from testcase to pageobject file
	//concatenated driver.
	
	public HomePage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	public WebElement preferences;

}
