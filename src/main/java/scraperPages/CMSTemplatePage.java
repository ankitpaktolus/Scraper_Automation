package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CMSTemplatePage extends BaseLibrary {

    ActionUtils actionUtils = new ActionUtils();
    String CMSTemplateName= "AutomationCMSTest";
    public CMSTemplatePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul//li//a[@href='https://dev.pheonix.paktolus.io/admin/cms']")
    WebElement CMSTemplate;
    @FindBy(xpath = "//a[contains(text(),'Add Template')]")
    WebElement addTemplate;
    @FindBy(xpath = "//label[contains(text(),'CMS Title')]//following-sibling::input")
    WebElement CMSTitleName;
    @FindBy(xpath = "//span[@class='select2-selection__placeholder' and contains(text(),'Attribute Name')]")
    WebElement addAttribute;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    WebElement selectAttributeName;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    WebElement selectHighlightedText;
    @FindBy(xpath = "//span[@class='select2-selection__placeholder' and contains(text(),'Type')]")
    WebElement selectType;
    @FindBy(xpath = "//input[@placeholder='Value']")
    WebElement value1;
    @FindBy(xpath = "(//input[@placeholder='Value'])[2]")
    WebElement value2;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement setInput;
    @FindBy(xpath = "//li[@id='select2-type-70-result-rbzr-xpath']")
    WebElement selectTypeXpath;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addAttributeRow;
    @FindBy(xpath = "//input[@id='pagination']")
    WebElement pagination;
    @FindBy(xpath = "//input[@id='vehicle_card']")
    WebElement vehicleCard;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement save;
    @FindBy(xpath = "//input[@type='search']")
    WebElement search;
    @FindBy(xpath = "//a[@aria-label='View']")
    WebElement view;
    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement pageHeader;
    @FindBy(xpath = "//h1[@class='page-header']//a")
    WebElement backButton;
    @FindBy(xpath = "//span[@id='select2-pagination_type-container']")
    WebElement paginationType;


    public void addCMSTemplate() throws InterruptedException {
        ActionUtils.waitFor(5);
        ActionUtils.click(CMSTemplate);
        actionUtils.screenshot();
//        tradeInValue.sendKeys(Keys.BACK_SPACE);
//        ActionUtils.waitFor(3);
        ActionUtils.click(addTemplate);
        ActionUtils.set_text(CMSTitleName, "AutomationCMSTest");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(pagination);
        ActionUtils.set_text(pagination,"ul.pagination li:last-child a");
        ActionUtils.set_text(vehicleCard,"h2.vehicle-card-title  a");
        addCMSAttribute();

    }

    public void addCMSAttribute() throws InterruptedException {
//        SoftAssert soft = new SoftAssert();
        ActionUtils.scroll_till_element(addAttribute);
        ActionUtils.waitFor(4);
        ActionUtils.click(addAttribute);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectAttributeName, "VIN");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(selectType);
        ActionUtils.waitFor(2);
//        ActionUtils.set_text(setInput, "Xpath");
//        ActionUtils.click(selectTypeXpath);
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(value1,".AnkitTest1");
        ActionUtils.click(addAttributeRow);
        ActionUtils.scroll_till_element(addAttribute);
        ActionUtils.click(addAttribute);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectAttributeName, "Price");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(selectType);
        ActionUtils.set_text(selectAttributeName, "Xpath");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(value2, "//button[contains(text(),'Add')])");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
//        soft.assertAll();
    }

    public void viewCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AutomationCMSTest");
        ActionUtils.waitFor(3);
        ActionUtils.click(view);
        String viewPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(viewPageHeader);
        soft.assertEquals(viewPageHeader, "View CMS Template: AutomationCMSTest");
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(backButton);
        soft.assertAll();
    }

    @FindBy(xpath = "//a[@aria-label='Edit']")
    WebElement edit;
    @FindBy(xpath = "(//i[@aria-label='Remove'])[2]")
    WebElement removeAttribute2;
    public void editFeedTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AutomationCMSTest");
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        String editPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(editPageHeader);
        soft.assertEquals(editPageHeader, "Edit CMS Template: AutomationCMSTest");
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.clear(CMSTitleName);
        ActionUtils.set_text(CMSTitleName, "AutomationEditCMSTest");
        ActionUtils.scroll_till_element(paginationType);
        ActionUtils.click(paginationType);
        ActionUtils.set_text(setInput, "Scroll");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(removeAttribute2);
        ActionUtils.scroll_till_element(save);
        ActionUtils.waitFor(3);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        soft.assertAll();
    }

    @FindBy(xpath = "//tbody//td[@class='center']//span")
    WebElement status;
    @FindBy(xpath = "//input[@id='cmsStatus']//..//following-sibling::div[@class='toggle-switch']")
    WebElement cmsStatusToggleButton;
    public void deactivateCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AutomationEditCMSTest");
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        ActionUtils.click(cmsStatusToggleButton);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AutomationEditCMSTest");
        String Status= ActionUtils.get_text(status);
        System.out.println("Status is :"+ Status);
        soft.assertEquals(Status, "Inactive");
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        ActionUtils.waitFor(3);
        ActionUtils.click(cmsStatusToggleButton);
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AutomationEditCMSTest");
        String changeStatus= ActionUtils.get_text(status);
        System.out.println("Status is :"+ changeStatus);
        soft.assertEquals(changeStatus, "Active");
        ActionUtils.clear(search);
        soft.assertAll();
    }

    @FindBy(xpath = "//a[@aria-label='Delete']")
    WebElement delete;
    @FindBy(xpath = "//div[@class='modal-header position-relative']//h4")
    WebElement warningScreenPopUp;
    @FindBy(xpath = "//div[@class='modal-header position-relative']//button")
    WebElement crossIcon;
    @FindBy(xpath = "//div[@class='reset-modal']//div[@class='modal show']//form//div//button[contains(text(),'No')]")
    WebElement noButton;
    @FindBy(xpath = "//div[@class='reset-modal']//div[@class='modal show']//form//div//button[contains(text(),'Yes')]")
    WebElement yesButton;
    @FindBy(xpath = "//tr//td[contains(text(),'No matching records found')]")
    WebElement verifyDeleteCMS;
    public void removeCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AutomationEditCMSTest");
        ActionUtils.waitFor(5);
        ActionUtils.click(delete);
        ActionUtils.waitFor(5);
        String deleteScreenTitle= ActionUtils.get_text(warningScreenPopUp);
        soft.assertEquals(deleteScreenTitle, "Are you sure you want to DELETE this CMS?");
        actionUtils.screenshot();
        ActionUtils.click(crossIcon);
        ActionUtils.waitFor(5);
        ActionUtils.click(delete);
        ActionUtils.waitFor(5);
        ActionUtils.click(noButton);
        ActionUtils.waitFor(5);
        ActionUtils.click(delete);
        ActionUtils.waitFor(5);
        ActionUtils.click(yesButton);
//        String deleteFeedToastMessage = ActionUtils.get_text(verifyFeedDeleteToast);
//        soft.assertEquals(deleteFeedToastMessage,"Feed Template Delete Successfully");
//        System.out.println("Feed Template Delete Message "+ deleteFeedToastMessage);
        ActionUtils.waitFor(10);
        ActionUtils.set_text(search, "AutomationEditCMSTest");
        String verifyDeleteFeedTemplate = ActionUtils.get_text(verifyDeleteCMS);
        System.out.println(verifyDeleteFeedTemplate);
        soft.assertEquals(verifyDeleteFeedTemplate,"No matching records found");
        actionUtils.screenshot();
        ActionUtils.clear(search);
        soft.assertAll();
    }



}
