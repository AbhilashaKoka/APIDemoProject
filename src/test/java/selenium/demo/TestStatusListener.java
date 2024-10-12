package selenium.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestStatusListener extends BaseSetUp implements ITestListener {



    public void onTestFailure(ITestResult result){
        System.out.println("****TEST CASE FAILED****");
        try
        {
         FailedScreenshot(result.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void onTestFailureMethod2(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseSetUp) testClass).getDriver();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile=new File("path/to/screenshots/" + result.getName() + ".png");
        try{
            FileUtils.copyFile(srcFile,destFile);
            System.out.println("Screenshot take for failed test case: " + result.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("***********On Test Start Code go here**********");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("***********On Test Success Code go here**********");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("***********On Test Skipped Code go here**********");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("***********On Test FailedButWithInSuccessPercentage Code go here**********");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("***********On Test Failed With TimeOut Code go here**********");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("***********On  Start Code go here**********");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***********On Finish Code go here**********");
    }



    }
