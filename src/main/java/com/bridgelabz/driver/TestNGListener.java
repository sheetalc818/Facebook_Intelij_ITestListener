
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *  Purpose: Listener class for taking Screenshots when Test Executes.
 *
 *  @since   15-01-2020
 *
 ******************************************************************************/


package com.bridgelabz.driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.util.Date;

public class TestNGListener extends Browser implements ITestListener
{
    public TestNGListener(WebDriver driver) {

    }

    @Override
    public void onTestStart(ITestResult result)
    {
        try
        {
            Date date=new Date();
            String imageName="Image"+date.toString();
           screenshot(result.getMethod().getMethodName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {

    }
}
