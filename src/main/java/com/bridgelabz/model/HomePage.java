
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *
 *  Purpose: Test for Facebook Home page after Login to Facebook.
 *  @since   15-01-2020
 *
 ******************************************************************************/

package com.bridgelabz.model;
import com.bridgelabz.driver.Browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class HomePage extends Browser
{
    @FindBy(xpath = "//div[@class='clearfix _ikh _1hx']")
    private WebElement creatPostOption;

    @FindBy(xpath = " //div[@class='_1mf _1mj']")
    private WebElement creatPostText;

    @FindBy(xpath = "//button[@class='_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft' and @type='submit']")
    private WebElement clickOnCreatePostClickButton;

    @FindBy(xpath = "//div[@id='userNavigationLabel']")
    private WebElement dragDownToLogoutButton;

    @FindBy(id="logoutbutton")
    private WebElement logoutButton;


    //constructor
    public HomePage(WebDriver driver)
    {
        //Initialization
        PageFactory.initElements(driver, this);
    }

    //Utilization
    public void clickCreatePostButton()
    {
        creatPostOption.click();
    }

    public void clickAddStory()
    {
        creatPostText.sendKeys("Hello Friends.....");
    }

    public void clickPost()
    {
        clickOnCreatePostClickButton.click();
    }

    public void dragDown()
    {
        dragDownToLogoutButton.click();
    }

    public void clickOnLogoutButton()
    {
        logoutButton.click();
    }
}
