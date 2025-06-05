package scraperTest;

import scraperPages.AdvertiserDashboardPage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class AdvertiserDashboardTest extends BaseLibrary
{

    AdvertiserDashboardPage advertiserDashboardPage;
    ActionUtils actionUtils = new ActionUtils();

    @Step
    @Test(priority = 1)
    public void verifyAdvertiserDashboard() throws InterruptedException {
        advertiserDashboardPage = new AdvertiserDashboardPage();
        advertiserDashboardPage.advertiserDashboard();
        actionUtils.screenshot();
    }

}
