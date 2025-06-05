package scraperTest;

import scraperPages.CampaignBuilderPage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class CampaignBuilderTest extends BaseLibrary {

    CampaignBuilderPage campaignBuilderPage;
    ActionUtils actionUtils = new ActionUtils();

    @Step
    @Test(priority = 1)
    public void verifyCampaignDashboard() throws InterruptedException {
        campaignBuilderPage = new CampaignBuilderPage();
        campaignBuilderPage.campaignDashboard();

    }

    @Step
    @Test(priority = 2)
    public void verifyNegativeKeywordList() throws InterruptedException {
        campaignBuilderPage.createNegativeKeywordList();
        campaignBuilderPage.editNegativeKeywordList();
        campaignBuilderPage.cloneNegativeKeywordList();
        campaignBuilderPage.deleteNegativeKeywordList();
    }

    @Step
    @Test(priority = 3)
    public void verifyProductAlias() throws InterruptedException {
        campaignBuilderPage.addProductAlias();
        campaignBuilderPage.editProductAlias();
        campaignBuilderPage.removeAllProductAlias();
    }
}
