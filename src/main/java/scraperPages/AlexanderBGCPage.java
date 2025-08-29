package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static scraperPages.AdvertiserDashboardPage.recordPerPage;

public class AlexanderBGCPage extends BaseLibrary
{
    ActionUtils actionUtils = new ActionUtils();

    String AdvertiserName = "Alexander BGC";
    public AlexanderBGCPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement search;
    @FindBy(xpath = "//tbody//tr//td[1]")
    WebElement getAdvertiserName;
    @FindBy(xpath = "//tbody//tr//td[2]")
    WebElement totalActiveFeedRecord;
    @FindBy(xpath = "//tbody//tr//td[5]")
    WebElement customFeed;
    @FindBy(xpath = "//p[contains(text(),'Total Active Feed Records')]//preceding-sibling::p")
    WebElement activeFeedCount;
    @FindBy(xpath = "//a[@aria-label='Feeds']")
    WebElement viewFeeds;
    @FindBy(xpath = "//p[@class='feed-heading mb-0']")
    WebElement inventoryFeeds;
    @FindBy(xpath = "//div[@class='feed-cms mb-3']")
    WebElement UseCMS;
    @FindBy(xpath = "//a[@href='https://dev.pheonix.paktolus.io/admin/advertisement/advertiser/18/view']")
    WebElement viewAdvertiser;
    @FindBy(xpath = "//h3[@class='page-header']")
    public static WebElement pageHeader;
    @FindBy(xpath = "//a[@aria-label='Edit']")
    public static WebElement edit;
    @FindBy(xpath = "//h3[@class='page-header']//a")
    public static WebElement backButton;
    @FindBy(xpath = "//h1[@class='page-header']//a")
    WebElement back;
    public void alexanderBGCAdvertiser() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search,AdvertiserName);
        ActionUtils.waitFor(5);
        String advertiserName = ActionUtils.get_text(getAdvertiserName);
        soft.assertEquals(advertiserName, AdvertiserName);
        String TotalActiveFeedRecord = ActionUtils.get_text(totalActiveFeedRecord);
        System.out.println("Total Active Feed Record = "+TotalActiveFeedRecord);
        int CustomFeed = Integer.parseInt(ActionUtils.get_text(customFeed));
        System.out.println("Total Custom Feed = "+CustomFeed);
        viewAdvertiser();
        editAdvertiser();
        viewFeeds();
        List<WebElement> feedSubscription = driver.findElements(By.xpath("//th[contains(text(),'Feed Subscription')]//..//..//..//tbody//tr//td"));
        int feedSubscriptionCount = feedSubscription.size();
        System.out.println(feedSubscriptionCount);
        soft.assertEquals(CustomFeed,feedSubscriptionCount);
        String countOfActiveFeedRecord = ActionUtils.get_text(activeFeedCount);
        soft.assertEquals(TotalActiveFeedRecord, countOfActiveFeedRecord);
        addFeedSubscription();
        soft.assertAll();
    }

    public void viewAdvertiser() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(5);
        ActionUtils.click(viewAdvertiser);
        String PageHeader = ActionUtils.get_text(pageHeader);
        soft.assertEquals(PageHeader,"View Advertiser");
        actionUtils.screenshot();
        ActionUtils.waitFor(5);
        ActionUtils.click(backButton);
        ActionUtils.set_text(search,AdvertiserName);
        ActionUtils.waitFor(5);
        soft.assertAll();
    }

    public void editAdvertiser() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(5);
        ActionUtils.click(edit);
        String PageHeader = ActionUtils.get_text(pageHeader);
        soft.assertEquals(PageHeader,"Edit Advertiser");
        ActionUtils.waitFor(5);
        actionUtils.screenshot();
        ActionUtils.click(backButton);
        ActionUtils.set_text(search,AdvertiserName);
        ActionUtils.waitFor(5);
        soft.assertAll();
    }

    public void viewFeeds() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(5);
        ActionUtils.click(viewFeeds);
        String PageHeader = ActionUtils.get_text(inventoryFeeds);
        soft.assertEquals(PageHeader,"Dynamic Display Feeds");
        ActionUtils.waitFor(5);
        actionUtils.screenshot();
        String useCMS =ActionUtils.get_text(UseCMS);
        System.out.println("Use CMS in the Advertiser = "+useCMS);
//        ActionUtils.click(backButton);
        soft.assertAll();
    }

    @FindBy(xpath = "//p[contains(text(),'No Price')]//preceding-sibling::p")
    WebElement noPrice;
    @FindBy(xpath = "//p[contains(text(),'No image')]//preceding-sibling::p")
    WebElement noImage;
    @FindBy(xpath = "//button[contains(text(),'Add Feed Subscription')]")
    WebElement addFeedSubscriptionButton;
    @FindBy(xpath = "//input[@placeholder='Feed Name']")
    WebElement feedName;
    @FindBy(xpath = "//select[@id='feedType']")
    WebElement feedType;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    public static WebElement selectHighlightedText;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public static WebElement searchName;
    @FindBy(xpath = "//span[@class='select2-selection__placeholder' and contains(text(),'Select Feed Format')]")
    WebElement selectFeedFormat;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='dataTables_info']")
    WebElement totalCount;
    public void addFeedSubscription() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        String NoPriceCount = ActionUtils.get_text(noPrice);
        System.out.println("No Price = "+NoPriceCount);
        int NoImageCount = Integer.parseInt(ActionUtils.get_text(noImage));
        System.out.println("No Images = "+NoImageCount);
        ActionUtils.click(addFeedSubscriptionButton);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.set_text(feedName,"Automation Feed Test");
        ActionUtils.select_by_value(feedType,"2");
        ActionUtils.waitFor(3);
        ActionUtils.click(selectFeedFormat);
        ActionUtils.set_text(searchName,"AutomationTest");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        ActionUtils.waitFor(3);
        editFeedSubscription();
        ActionUtils.waitFor(3);
        viewFeedSubscription();
        ActionUtils.set_text(search, "No Image");
        int totalNoImageCount = Integer.parseInt(ActionUtils.get_text(totalCount).split(" ")[5]);
        soft.assertEquals(NoImageCount,totalNoImageCount);
        ActionUtils.waitFor(3);
        ActionUtils.click(back);
        cloneFeedSubscription();
        deleteFeedSubscription();
        soft.assertAll();
    }

    @FindBy(xpath = "//div[contains(text(),'Automation Feed Test')]//following-sibling::div//a[1]")
    WebElement editFeedSubscription;
    @FindBy(xpath = "//label[@for='setMilesForNewVehicle']")
    WebElement setMilesValueField;
    @FindBy(xpath = "//div[contains(text(),'Automation Feed Test')]//following-sibling::div//a[2]")
    WebElement viewFeedSubscription;
    @FindBy(xpath = "//div[contains(text(),'Automation Feed Test')]//following-sibling::div//a[3]")
    WebElement cloneFeedSubscription;
    @FindBy(xpath = "//div[contains(text(),'Automation Feed Test copy')]//following-sibling::div//a[5]")
    WebElement removeClonedFeedSubscription;
    @FindBy(xpath = "//div[contains(text(),'Automation Feed Test')]//following-sibling::div//a[5]")
    WebElement deleteFeedSubscription;
    @FindBy(xpath = "(//button[contains(text(),'Yes')])[1]")
    WebElement yesButton;
    public void editFeedSubscription() throws InterruptedException {
        ActionUtils.scroll_till_element(editFeedSubscription);
        ActionUtils.click(editFeedSubscription);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(setMilesValueField);
        ActionUtils.click(setMilesValueField);
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
    }

    public void viewFeedSubscription() throws InterruptedException {
        ActionUtils.scroll_till_element(viewFeedSubscription);
        ActionUtils.click(viewFeedSubscription);
        ActionUtils.selectRecordPerPage(recordPerPage,"100");
        actionUtils.screenshot();
    }

    public void cloneFeedSubscription() throws InterruptedException {
        ActionUtils.scroll_till_element(cloneFeedSubscription);
        ActionUtils.click(cloneFeedSubscription);
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        ActionUtils.scroll_till_element(removeClonedFeedSubscription);
        ActionUtils.waitFor(3);
        ActionUtils.click(removeClonedFeedSubscription);
        ActionUtils.waitFor(3);
        ActionUtils.click(yesButton);
    }

    public void deleteFeedSubscription() throws InterruptedException {
        ActionUtils.waitFor(3);
        ActionUtils.scroll_till_element(deleteFeedSubscription);
        ActionUtils.click(deleteFeedSubscription);
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(yesButton);
    }
}
