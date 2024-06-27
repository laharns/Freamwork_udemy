package Testng_package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){


    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("I successfully executed Listener pass code");
    }
    @Override
    public void onTestFailure(ITestResult result){
        //screenshot code
        //response if API is failed
        System.out.println("I Failed executed Listener pass code"+ result.getName());

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

    }


}
