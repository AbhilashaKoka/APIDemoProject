package seleniumTestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestStatusListener extends BaseSetUp implements ITestListener {

    public void onTestFailure(ITestResult result){
        System.out.println("Test case Failed");
        try
        {
         FailedScreenshot(result.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
