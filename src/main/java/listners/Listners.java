package listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mobilebaseclass.Base;

public class Listners implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	@Override
	public void onStart(ITestContext context)
	{
		
	}
   @Override
   public void onTestFailedButWithinSuccessPercentage(ITestResult result)
   {
	   
   }
   @Override
   public void onTestFailure(ITestResult result)
   {
	   String s=result.getName();
	   try {
		Base.getScreenShot(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public void onFinish(ITestContext context)
   {
	   
   }
   
}
