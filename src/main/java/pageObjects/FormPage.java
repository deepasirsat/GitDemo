package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	public
	WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	
	public WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Afghanistan']")
	public WebElement countryName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Brazil']")
	public WebElement countryName1;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List< WebElement> product1;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	public  List <WebElement> product2;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement basketButton;
	
	public WebElement getNameField()
	{
		System.out.println("trying to find the namefield");
		return nameField;
	}
   
	
}
