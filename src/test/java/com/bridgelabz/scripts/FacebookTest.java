
/******************************************************************************
 *
 *  Author   Sheetal Chaudhari
 *
 *  Purpose: Created Properties for test Facebook login page.
 *  @since   15-01-2020
 *
 ******************************************************************************/
package com.bridgelabz.scripts;

import com.bridgelabz.driver.Browser;
import com.bridgelabz.driver.TestNGListener;
import com.bridgelabz.model.HomePage;
import com.bridgelabz.model.LoginPage;
import com.bridgelabz.controller.DataDriven;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class FacebookTest extends Browser
{
    @DataProvider(name = "testData")
    public Object[][] getData()
    {
        DataDriven config = new DataDriven(EXCELPATH);
        int rows = config.getrowcount(0);

        Object[][] credentials = new Object[rows][2];

            for (int i = 0; i < rows; ++i)
            {
                for (int j=0;j<2;j++){
                credentials[i][0] = config.getData(0, i, 0);
                credentials[i][1] = config.getData(0, i, 1);
            } }
        return credentials;
    }


    @Test(dataProvider = "testData")
    public void loginPageTest(String userName,String password) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

            loginPage.setUsername(userName);
            loginPage.setPassword(password);
            loginPage.clickLogin();

            homePage.clickCreatePostButton();
            homePage.clickAddStory();
            homePage.clickPost();
            Thread.sleep(500);
            homePage.dragDown();
            Thread.sleep(500);
            homePage.clickOnLogoutButton();
    }
}
