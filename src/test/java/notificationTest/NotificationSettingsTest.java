package notificationTest;

import baselibrary.BaseLibrary;
import io.qameta.allure.Step;
import notificationsPages.NotificationSettingsPage;
import org.testng.annotations.Test;

public class NotificationSettingsTest extends BaseLibrary {

    NotificationSettingsPage notificationSettingsPage;

    @Step
    @Test(priority = 1)
    public void verifyNotification(){
        notificationSettingsPage = new NotificationSettingsPage();
        notificationSettingsPage.clickOnNotificationTab();

    }

    @Step
    @Test(priority = 2)
    public void verifyUnsuccessfulAdvertiserEdit(){
        notificationSettingsPage.unsuccessfulAdvertiserEdit();
    }

    @Step
    @Test(priority = 3)
    public void verifyCouponStatusChangeEdit(){
        notificationSettingsPage.couponStatusChangeEdit();
    }

    @Step
    @Test(priority = 4)
    public void verifyStoreChangesEdit(){
        notificationSettingsPage.storeChangesEdit();
    }

}
