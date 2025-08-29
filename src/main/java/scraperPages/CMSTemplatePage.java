package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CMSTemplatePage extends BaseLibrary {
    ActionUtils actionUtils = new ActionUtils();
    String CMSTemplateName= "AutomationCMSTest";
    public CMSTemplatePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul//li//a[@href='https://"+env+".pheonix.paktolus.io/admin/cms']")
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
    @FindBy(xpath = "(//tbody//tr[4]//td//div//span[@class='select2-selection__rendered'])[3]")
    WebElement fetchAPIValues;
    @FindBy(xpath = "//table//tr//th//i")
    WebElement EnableScraperToolTip;


    public void addCMSTemplate() throws InterruptedException {
        ActionUtils.waitFor(5);
        ActionUtils.click(CMSTemplate);
        actionUtils.screenshot();
        ActionUtils.click(addTemplate);
        String pageTitle = ActionUtils.get_text(pageHeader);
        Assert.assertEquals(pageTitle, "Add CMS Template");
        ActionUtils.set_text(CMSTitleName, CMSTemplateName);
        actionUtils.screenshot();
        List<WebElement> columnCount = driver.findElements(By.xpath("//table//tr//th"));
        List<String> columnNames = new ArrayList<>();
        for (int i=0; i<columnCount.size(); i++){
            String columnName = columnCount.get(i).getText();
            columnNames.add(columnName);
        }
        List<String> expectedColumnNames = Arrays.asList("Attribute", "Type","Value", "Enable Scraper", "Fetch API", "Remove");
        Assert.assertEquals(columnNames,expectedColumnNames);
        System.out.println("Total Column is: "+columnCount.size());
        System.out.println(columnNames);
        ActionUtils.verifyToolTipValue(EnableScraperToolTip, "data-bs-original-title", "Enabling this toggle means the attribute will be scraped.");
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
        ActionUtils.set_text(selectAttributeName, "Body Style");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(selectType);
        ActionUtils.set_text(selectAttributeName, "Xpath");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(value2, "//button[contains(text(),'Add')])");
        ActionUtils.click(fetchAPIValues);
        List<WebElement> fetchAPICount = driver.findElements(By.xpath("//span[@class='select2-results']//ul//li"));
        List<String> fetchAPINames = new ArrayList<>();
        for (int i=0; i<fetchAPICount.size(); i++){
            String Name = fetchAPICount.get(i).getText();
            fetchAPINames.add(Name);
        }
        System.out.println(fetchAPINames);
        List<String> expectedFetchAPINames = Arrays.asList("API First", "Scraper First", "API Not Available");
        Assert.assertEquals(fetchAPINames,expectedFetchAPINames,"The fetched API Values names matched the expected names.");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
//        soft.assertAll();
    }

    public void viewCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, CMSTemplateName);
        ActionUtils.waitFor(3);
        ActionUtils.click(view);
        String viewPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(viewPageHeader);
        soft.assertEquals(viewPageHeader, "View CMS Template: "+ CMSTemplateName);
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
        ActionUtils.set_text(search, CMSTemplateName);
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        String editPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(editPageHeader);
        soft.assertEquals(editPageHeader, "Edit CMS Template: "+CMSTemplateName);
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.clear(CMSTitleName);
        ActionUtils.set_text(CMSTitleName, CMSTemplateName+"Edit");
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
        ActionUtils.set_text(search, CMSTemplateName+"Edit");
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        ActionUtils.click(cmsStatusToggleButton);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, CMSTemplateName+"Edit");
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
        ActionUtils.set_text(search, CMSTemplateName+"Edit");
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
    @FindBy(xpath = "(//form[@name='confirmDeleteCmsFrm']//div//p)[1]")
    WebElement deleteMessage;
    @FindBy(xpath = "//div[@class='modal-header position-relative']//following-sibling::div//div[@class='col-md-12 col-sm-12 control-label']")
    WebElement deactivateMessage;

    public void removeCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, CMSTemplateName+"Edit");
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
        ActionUtils.set_text(search, CMSTemplateName+"Edit");
        String verifyDeleteFeedTemplate = ActionUtils.get_text(verifyDeleteCMS);
        System.out.println(verifyDeleteFeedTemplate);
        soft.assertEquals(verifyDeleteFeedTemplate,"No matching records found");
        actionUtils.screenshot();
        ActionUtils.clear(search);
        soft.assertAll();
    }

    public void removeUsedCMSTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.clear(search);
        ActionUtils.set_text(search, "AnkitTest1");
        ActionUtils.waitFor(3);
        ActionUtils.click(delete);
        String warningPopUp = ActionUtils.get_text(warningScreenPopUp);
        soft.assertEquals(warningPopUp, "Warning!");
        ActionUtils.waitFor(3);
        String deleteUsedFeedMessage = ActionUtils.get_text(deleteMessage);
        System.out.println(deleteUsedFeedMessage);
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(crossIcon);
        soft.assertAll();
    }

    public void deactivateUsedCMTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.clear(search);
        ActionUtils.set_text(search, "AnkitTest1");
        ActionUtils.click(edit);
        String editPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(editPageHeader);
        soft.assertEquals(editPageHeader, "Edit CMS Template: "+"AnkitTest1");
        ActionUtils.waitFor(3);
        ActionUtils.click(cmsStatusToggleButton);
        String warningPopUp = ActionUtils.get_text(warningScreenPopUp);
        soft.assertEquals(warningPopUp, "Warning!");
        String deactivateUsedFeedMessage = ActionUtils.get_text(deactivateMessage);
        System.out.println(deactivateUsedFeedMessage);
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(crossIcon);
        ActionUtils.waitFor(3);
        ActionUtils.click(backButton);
        soft.assertAll();
    }
}
