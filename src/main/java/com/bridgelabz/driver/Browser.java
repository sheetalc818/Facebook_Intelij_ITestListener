
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *  Purpose: for set system property, Initializing the browser and launch the
 *
 *  @since   15-01-2020
 *
 ******************************************************************************/

package com.bridgelabz.driver;
import com.bridgelabz.constantpaths.IConstants;
import com.bridgelabz.property.Library;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Browser implements IConstants
{
    public static WebDriver driver = null;
    public static TestNGListener eventListener;
    ChromeOptions options = new ChromeOptions();

    // for launching the browser

    @BeforeMethod(description = "load driver for test")
    public void setUp()
    {
           options.addArguments("--disable-notifications");
           System.setProperty(CHROMEKEY, CHROMEVALUE);
           driver = new ChromeDriver(options);
           String url = Library.getProperty(CONFIGPATH, "URL");
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           eventListener = new TestNGListener(driver);
           driver.get(url);
    }

    /**
     * for take the screenshot
     */
    public void screenshot(String TestName) throws IOException
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Date date=new Date();
        File destinationFile = new File("/home/admin123/DataDrivenTestForFacebook/Screenshots.png2020/"+date.toString());
        FileUtils.copyFile(sourceFile, destinationFile);
    }

    @AfterMethod(description = "close driver after test")
    public void tearDown()
    {
        driver.close();
    }
}

