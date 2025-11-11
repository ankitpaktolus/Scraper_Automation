package notificationsPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class NotificationSettingsPage extends BaseLibrary {

    ActionUtils actionUtils = new ActionUtils();

    public NotificationSettingsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space(text())='Notifications']")
    WebElement NotificationTab;
    @FindBy(xpath = "//li//a[@href='https://staging.pheonix.paktolus.io/admin/notifications/notfication-events']")
    WebElement  NotificationSettings;
    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement pageHeader;
    @FindBy(xpath = "//*[@id='notificationEventsTable']/tbody/tr[1]/td[5]/a/i")
    WebElement UnsuccessfulAdvertiserEdit;
    @FindBy(xpath = "//*[@id='notificationEventsTable']/tbody/tr[2]/td[5]/a")
    WebElement CouponStatusChangeEdit;
    @FindBy(xpath = "//*[@id='notificationEventsTable']/tbody/tr[3]/td[5]/a/i")
    WebElement StoreChangesEdit;
    @FindBy(xpath = "/html/body/div[1]/div[1]/section[2]/div[1]/div/h1/a/img")
    WebElement BackIcon;
    @FindBy(xpath = "//*[@id='btnAddUser']")
    WebElement AddUserButton;
    @FindBy(xpath = "//*[@id='addUserModal']/div/div/div[1]/button/span")
    WebElement CrossButton;
    @FindBy(xpath = "//*[@id='addUserModal']/div/div/div[3]/button[2]")
    WebElement CancelButton;


    public void clickOnNotificationTab(){
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(NotificationTab);
        ActionUtils.click(NotificationSettings);
        String PageHeader=ActionUtils.get_text(pageHeader);
        System.out.println(PageHeader);
        actionUtils.screenshot();
        soft.assertEquals(PageHeader,"Notifications");
        soft.assertAll();
    }

    public void unsuccessfulAdvertiserEdit(){
        ActionUtils.click(UnsuccessfulAdvertiserEdit);
        actionUtils.screenshot();
        String PageHeader=ActionUtils.get_text(pageHeader);
        System.out.println(PageHeader);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CrossButton);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CancelButton);
        ActionUtils.click(BackIcon);
    }
    public void couponStatusChangeEdit(){
        ActionUtils.click(CouponStatusChangeEdit);
        actionUtils.screenshot();
        String PageHeader=ActionUtils.get_text(pageHeader);
        System.out.println(PageHeader);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CrossButton);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CancelButton);
        ActionUtils.click(BackIcon);
    }

    public void storeChangesEdit(){
        ActionUtils.click(StoreChangesEdit);
        actionUtils.screenshot();
        String PageHeader=ActionUtils.get_text(pageHeader);
        System.out.println(PageHeader);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CrossButton);
        ActionUtils.click(AddUserButton);
        ActionUtils.click(CancelButton);
        ActionUtils.click(BackIcon);
    }
}

