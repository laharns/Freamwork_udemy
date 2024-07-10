package rahulsheety.TestComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentsreoprtsNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result){
      test =   extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }
    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.get().log(Status.PASS,"Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result){

        extentTest.get().fail(result.getThrowable());
        //Screen short:
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        /*catch (IllegalAccessException e1) {
          e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }catch (SecurityException e1){
            e1.printStackTrace();
        }*/

        String filepath = null;
        try {
            filepath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());

    }
    @Override
    public void onTestSkipped(ITestResult result){

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }
    @Override
    public void onStart(ITestContext context){

    }
    @Override
    public void onFinish(ITestContext context){
        extent.flush();

    }



}
