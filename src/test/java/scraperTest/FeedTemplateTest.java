package scraperTest;

import scraperPages.FeedTemplatePage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class FeedTemplateTest extends BaseLibrary {

    FeedTemplatePage feedTemplatePage;
    ActionUtils actionUtils = new ActionUtils();
    @Step
    @Test(priority = 1)
    public void verifyFeedTemplate() throws InterruptedException {
        feedTemplatePage = new FeedTemplatePage();
        feedTemplatePage.addFeedTemplate();
        feedTemplatePage.viewFeedTemplate();
        feedTemplatePage.editFeedTemplate();
        feedTemplatePage.deactivateFeeTemplate();
        feedTemplatePage.removeFeedTemplate();
        feedTemplatePage.removeUsedFeedTemplate();
        feedTemplatePage.deactivateUsedFeeTemplate();
//        ob.editAttribute();
//        actionUtils.screenshot();
    }

}
