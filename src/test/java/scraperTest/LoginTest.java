package scraperTest;

import scraperPages.LoginPage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseLibrary
{
    LoginPage loginPage;
    ActionUtils actionUtils = new ActionUtils();

    @BeforeTest
    public void launchURL(){
        getLaunchUrl("chrome");
        loginPage = new LoginPage();
        loginPage.deleteAllure();
    }

    @Step
    @Test(priority = 1)
    public void userLogin(){
        loginPage.inputUserValidLogin();
        actionUtils.screenshot();
    }

    @Step
    @Test(priority = 2)
    public void clickAdvertisement() throws InterruptedException {
        loginPage.clickOnAdvertisement();
        ActionUtils.waitFor(2);
        actionUtils.screenshot();
    }

//    @Step
//    @AfterTest
//    public void userLogout() throws InterruptedException {
//        ActionUtils.waitFor(5);
//        loginPage.logOut();
//        actionUtils.screenshot();
////        driver.quit();
//    }
}
