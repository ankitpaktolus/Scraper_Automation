package scraperTest;

import scraperPages.AlexanderBGCPage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class AlexanderBGCTest extends BaseLibrary
{

    AlexanderBGCPage alexanderBGCPage;
    ActionUtils actionUtils = new ActionUtils();
    @Step
    @Test(priority = 1)
    public void verifyAlexanderBGCAdvertiser() throws InterruptedException {
        alexanderBGCPage = new AlexanderBGCPage();
        alexanderBGCPage.alexanderBGCAdvertiser();
        actionUtils.screenshot();
    }

}
