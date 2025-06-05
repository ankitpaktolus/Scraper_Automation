package scraperTest;

import scraperPages.CMSTemplatePage;
import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class CMSTemplateTest extends BaseLibrary {

    CMSTemplatePage cmsTemplatePage;
    ActionUtils actionUtils = new ActionUtils();

    @Step
    @Test(priority = 1)
    public void verifyCMSTemplate() throws InterruptedException {
        cmsTemplatePage = new CMSTemplatePage();
        cmsTemplatePage.addCMSTemplate();
        cmsTemplatePage.viewCMSTemplate();
        cmsTemplatePage.editFeedTemplate();
        cmsTemplatePage.deactivateCMSTemplate();
        cmsTemplatePage.removeCMSTemplate();
    }

}
