
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *
 *  Purpose: Test for Facebook login page.
 *  @since   15-01-2020
 *
 ******************************************************************************/

package com.bridgelabz.model;
import com.bridgelabz.driver.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginPage extends Browser
{
    @FindBy(id="email")
    private WebElement email;

    @FindBy(id ="pass")
    private WebElement password;

    @FindBy(xpath="//input[@id='u_0_b']")
    private WebElement loginBtn;

    //Initialization
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //Utilization
    public void setUsername(String userName)
    {
        email.sendKeys(userName);
    }

    public void setPassword(String password)
    {
        this.password.sendKeys(password);
    }

    public void clickLogin()
    {
        loginBtn.click();
    }

}
