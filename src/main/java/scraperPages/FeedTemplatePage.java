package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FeedTemplatePage extends BaseLibrary {

    ActionUtils actionUtils = new ActionUtils();
    public FeedTemplatePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul//li//a[@href='https://dev.pheonix.paktolus.io/admin/advertisement/feed-templates']")
    WebElement feed_template;
    @FindBy(xpath = "//h1[contains(text(),'Feed Template')]")
    WebElement feed_template_header_title;
    @FindBy(xpath = "//a[contains(text(),'Add Feed Template')]")
    WebElement addFeed;
    @FindBy(xpath = "//input[@name='service_name']")
    WebElement feedName;
    @FindBy(xpath = "//span[@id='select2-master_feed_extension-container']")
    WebElement fileExtension;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    public static WebElement selectHighlightedText;
    @FindBy(xpath = "//span[@id='select2-master_feed_delimeter-container']")
    WebElement selectDelimeter;
    @FindBy(xpath = "//label[@for='missingPriceCheckbox']")
    WebElement missingPriceField;
    @FindBy(xpath = "//label[@for='setMilesForNewVehicle']")
    WebElement setMilesValueField;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addButton;
    @FindBy(xpath = "//select[@id='attributeType']")
    WebElement selectAttributeType;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    WebElement selectAttributeName;
    @FindBy(xpath ="(//input[@class='select2-search__field'])[3]")
    WebElement selectAttributeName2;
    @FindBy(xpath ="(//input[@class='select2-search__field'])[5]")
    WebElement selectAttributeName3;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[7]")
    WebElement selectEditAttribute;
    @FindBy(xpath = "//input[@id='feed_header']")
    WebElement addFeedHeader;
    @FindBy(xpath = "//input[@placeholder='Select String Operation']")
    WebElement selectStringOperation;
    @FindBy(xpath = "//button[@id='saveAttributeTemplate']")
    WebElement saveAttribute;
    @FindBy(xpath = "//div[contains(text(),'Attribute added successfully')]")
    WebElement successfullyAddAttribute;
    @FindBy(xpath = "(//input[@placeholder='Feed Header Name'])[2]")
    WebElement addFeedHeader2;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement next;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement save;

    @FindBy(xpath = "(//tbody[@id='attributeSettings']//i[@aria-label='Edit'])[3]")
    WebElement editAttribute;
    @FindBy(xpath = "//h4[contains(text(),'Edit Attribute')]")
    WebElement editAttributeScreen;
    @FindBy(xpath = "//li[@title='Model']//span")
    WebElement removeAttribute;
    @FindBy(xpath = "(//span[@class='select2-selection__choice__remove'])[8]")
    WebElement removeStringOperation;
    @FindBy(xpath = "//input[@placeholder='Limit']")
    WebElement textLimit;
    @FindBy(xpath = "//small[contains(text(),'Please enter a valid integer value')]")
    WebElement textLimitError;
    @FindBy(xpath = "//div[contains(text(),'Attribute setting updated successfully')]")
    WebElement updatedAddAttribute;
    @FindBy(xpath = "//input[@type='search']")
    WebElement search;
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
    @FindBy(xpath = "//div[contains(text(),'Feed Template Delete Successfully')]")
    WebElement verifyFeedDeleteToast;
    @FindBy(xpath = "//tr//td[contains(text(),'No matching records found')]")
    WebElement verifyDeleteFeed;
    @FindBy(xpath = "(//form[@name='confirmDeleteFeedTemplateFrm']//div//p)[1]")
    WebElement deleteMessage;
    @FindBy(xpath = "//span[contains(text(),'Active')]//preceding-sibling::div[@class='toggle-switch']")
    WebElement statusToggleButton;
    @FindBy(xpath = "//div[@class='modal-header position-relative']//following-sibling::div//div[@class='col-md-12']")
    WebElement deactivateMessage;

    public void addFeedTemplate() throws InterruptedException {
        ActionUtils.click(feed_template);
        String feedHeader = ActionUtils.get_text(feed_template_header_title);
        System.out.println(feedHeader);
        ActionUtils.click(addFeed);
        ActionUtils.set_text(feedName, "AnkitFeedAutomation");
        ActionUtils.click(fileExtension);
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(selectDelimeter);
        ActionUtils.click(selectHighlightedText);
        actionUtils.screenshot();
        selectFeedFields();
        addAttribute();
    }

    public void selectFeedFields() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(missingPriceField);
        ActionUtils.click(setMilesValueField);
        actionUtils.screenshot();
        soft.assertAll();
    }

    public void addAttribute() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.scroll_till_element(addButton);
        ActionUtils.click(addButton);
        ActionUtils.select_by_value(selectAttributeType,"inventory_information");
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectAttributeName, "VIN");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(addFeedHeader, "VIN");
        ActionUtils.set_text(selectStringOperation, "None");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(saveAttribute);
        ActionUtils.waitFor(5);
        ActionUtils.scroll_till_element(addButton);
        ActionUtils.click(addButton);
        ActionUtils.select_by_value(selectAttributeType,"inventory_information");
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectAttributeName2, "Make");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(addFeedHeader, "make");
        ActionUtils.set_text(selectStringOperation, "Uppercase");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(saveAttribute);
        ActionUtils.waitFor(5);
        ActionUtils.scroll_till_element(addButton);
        ActionUtils.click(addButton);
        ActionUtils.select_by_value(selectAttributeType,"inventory_information");
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectAttributeName3, "Model");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.set_text(addFeedHeader, "model");
        ActionUtils.set_text(selectStringOperation, "Lowercase");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(saveAttribute);
        String attributeToastMessage = ActionUtils.get_text(successfullyAddAttribute);
        System.out.println(attributeToastMessage);
        soft.assertEquals(attributeToastMessage,"Attribute added successfully");
        actionUtils.screenshot();
//        ActionUtils.click(save);
        editAttribute();
        addMapping();
        soft.assertAll();
    }
    @FindBy(xpath = "//a[contains(text(),'Mapping')]")
    WebElement mappingSection;
    @FindBy(xpath = "//select[@id='tableSelect']")
    WebElement selectMapAttribute;
    @FindBy(xpath = "//button[contains(text(),'Add Attribute')]")
    WebElement addMappingAttribute;
    @FindBy(xpath = "//tbody//td//input[@class='form-control']")
    WebElement AllowedValue1;
    @FindBy(xpath = "//td//select[@class='form-control select2 select2-hidden-accessible']")
    WebElement mappedValue1;
    @FindBy(xpath = "//button[contains(text(),'Add allowed value')]")
    WebElement addAllowedValue;
    @FindBy(xpath = "(//tbody//td//input[@class='form-control'])[2]")
    WebElement AllowedValue2;
    @FindBy(xpath = "(//td//select[@class='form-control select2 select2-hidden-accessible'])[2]")
    WebElement mappedValue2;
    public void addMapping() throws InterruptedException {
//        ActionUtils.scroll_till_element(mappingSection);
//        ActionUtils.click(mappingSection);
        ActionUtils.waitFor(3);
        ActionUtils.scroll_till_element(next);
        ActionUtils.click(next);
        ActionUtils.scroll_till_element(addMappingAttribute);
        ActionUtils.select_by_value(selectMapAttribute,"1");
        ActionUtils.click(addMappingAttribute);
        actionUtils.screenshot();
        ActionUtils.waitFor(2);
        ActionUtils.scroll_till_element(AllowedValue1);
        ActionUtils.set_text(AllowedValue1, "Used");
        ActionUtils.waitFor(2);
        ActionUtils.select_by_value(mappedValue1, "Certified");
        ActionUtils.waitFor(2);
        ActionUtils.select_by_value(mappedValue1, "Used");
        ActionUtils.click(addAllowedValue);
        ActionUtils.scroll_till_element(AllowedValue2);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(AllowedValue2, "New");
        ActionUtils.waitFor(2);
        ActionUtils.select_by_value(mappedValue2, "New");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(save);
        ActionUtils.click(save);
    }

    public void editAttribute() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.scroll_till_element(editAttribute);
        ActionUtils.click(editAttribute);
        String screenTitle = ActionUtils.get_text(editAttributeScreen);
        System.out.println("Screen Title = "+screenTitle);
        soft.assertEquals(screenTitle,"Edit Attribute");
        ActionUtils.click(removeAttribute);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(selectEditAttribute, "Title");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.clear(addFeedHeader);
        ActionUtils.set_text(addFeedHeader, "title");
        ActionUtils.click(removeStringOperation);
        ActionUtils.set_text(selectStringOperation, "Text length");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(textLimit, "aa");
        String limitError = ActionUtils.get_text(textLimitError);
        soft.assertEquals(limitError,"Please enter a valid integer value");
        actionUtils.screenshot();
        ActionUtils.waitFor(2);
        ActionUtils.clear(textLimit);
        ActionUtils.set_text(textLimit, "25");
        ActionUtils.click(saveAttribute);
        String updateToastMessage = ActionUtils.get_text(updatedAddAttribute);
        soft.assertEquals(updateToastMessage,"Attribute setting updated successfully");
        actionUtils.screenshot();
        soft.assertAll();
    }

    @FindBy(xpath = "//a[@aria-label='View']")
    public static WebElement view;
    @FindBy(xpath = "//h3[@class='page-header']")
    public static WebElement pageHeader;
    @FindBy(xpath = "//h3[@class='page-header']//a")
    public static WebElement backButton;

    public void viewFeedTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AnkitFeedAutomation");
        ActionUtils.waitFor(3);
        ActionUtils.click(view);
        String viewPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(viewPageHeader);
        soft.assertEquals(viewPageHeader, "View Feed Details");
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(backButton);
        soft.assertAll();
    }

    @FindBy(xpath = "//a[@aria-label='Edit']")
    public static WebElement edit;
    public void editFeedTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AnkitFeedAutomation");
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        String editPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(editPageHeader);
        soft.assertEquals(editPageHeader, "Edit Feed Template: "+"AnkitFeedAutomation");
        ActionUtils.waitFor(3);
        ActionUtils.clear(feedName);
        ActionUtils.set_text(feedName, "AnkitEditFeedAutomation");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(next);
        ActionUtils.click(next);
        editMapping();
        ActionUtils.scroll_till_element(save);
        ActionUtils.waitFor(3);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        soft.assertAll();
    }

    @FindBy(xpath = "(//tbody//td//input[@class='form-control'])[3]")
    WebElement allowedValues3;
    @FindBy(xpath = "(//td//select[@class='form-control select2 select2-hidden-accessible'])[3]")
    WebElement mappedValue3;
    @FindBy(xpath = "(//tbody//td//input[@class='form-control'])[4]")
    WebElement allowedValues4;
    @FindBy(xpath = "(//td//select[@class='form-control select2 select2-hidden-accessible'])[4]")
    WebElement mappedValue4;
    @FindBy(xpath = "//li[@title='Not Available']//span")
    WebElement removeMappedValue;
    @FindBy(xpath = "(//button[contains(text(),'+ Add Valid string')])[4]")
    WebElement addValidString;
    @FindBy(xpath = "//button[@class='modal-close-btn']")
    WebElement crossAddValidStringPopUp;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement closeAddValidStringPopUp;
    @FindBy(xpath = "//input[@id='customValueInput']")
    WebElement addString;
    @FindBy(xpath = "//button[@id='saveCustomValue']")
    WebElement saveStringValue;
    @FindBy(xpath = "//li[@title='other']//span")
    WebElement removeOtherValue;
    @FindBy(xpath = "(//span[contains(text(),'Active')]//..//div[@class='toggle-switch'])[5]")
    WebElement mapEmptyToggle;
    @FindBy(xpath = "(//i[@class='fa fa-trash deleteAllowedValue'])[4]")
    WebElement removeAllowedValues4;
    @FindBy(xpath = "//h3[contains(text(),'availability')]//..//div//i[@aria-label='Remove']")
    WebElement removeMapAttribute;
    @FindBy(xpath = "//h3[contains(text(),'availability')]//..//..//button[contains(text(),'Add allowed value')]")
    WebElement addAllowedValue2;

    public void editMapping() throws InterruptedException {
        ActionUtils.scroll_till_element(addMappingAttribute);
        ActionUtils.select_by_value(selectMapAttribute,"40");
        ActionUtils.click(addMappingAttribute);
        ActionUtils.waitFor(2);
        ActionUtils.scroll_till_element(allowedValues3);
        ActionUtils.set_text(allowedValues3,"Available");
        ActionUtils.waitFor(2);
        ActionUtils.select_by_value(mappedValue3, "Available");
        ActionUtils.click(addAllowedValue2);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(allowedValues4,"Not Available");
        ActionUtils.select_by_value(mappedValue4, "Not Available");
        ActionUtils.waitFor(2);
        ActionUtils.click(removeMappedValue);
        ActionUtils.click(addValidString);
        ActionUtils.waitFor(2);
        ActionUtils.click(crossAddValidStringPopUp);
        ActionUtils.waitFor(2);
        ActionUtils.click(addValidString);
        ActionUtils.waitFor(2);
        ActionUtils.click(closeAddValidStringPopUp);
        ActionUtils.waitFor(2);
        ActionUtils.click(addValidString);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(addString,"other");
        actionUtils.screenshot();
        ActionUtils.click(saveStringValue);
        ActionUtils.waitFor(2);
        ActionUtils.click(removeOtherValue);
        ActionUtils.waitFor(2);
        ActionUtils.click(mapEmptyToggle);
        ActionUtils.waitFor(2);
        ActionUtils.click(removeAllowedValues4);
        ActionUtils.waitFor(2);
        ActionUtils.click(removeMapAttribute);
    }

    @FindBy(xpath = "//tbody//td[@class='center']//span")
    WebElement status;
    public void deactivateFeeTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AnkitEditFeedAutomation");
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        ActionUtils.click(statusToggleButton);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(next);
        ActionUtils.click(next);
        ActionUtils.scroll_till_element(save);
        ActionUtils.waitFor(3);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AnkitEditFeedAutomation");
        String Status= ActionUtils.get_text(status);
        System.out.println("Status is :"+ Status);
        soft.assertEquals(Status, "Inactive");
        actionUtils.screenshot();
        ActionUtils.waitFor(3);
        ActionUtils.click(edit);
        ActionUtils.waitFor(3);
        ActionUtils.click(statusToggleButton);
        ActionUtils.scroll_till_element(next);
        ActionUtils.click(next);
        ActionUtils.scroll_till_element(save);
        ActionUtils.waitFor(3);
        ActionUtils.click(save);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(search, "AnkitEditFeedAutomation");
        String changeStatus= ActionUtils.get_text(status);
        System.out.println("Status is :"+ changeStatus);
        soft.assertEquals(changeStatus, "Active");
        ActionUtils.clear(search);
        soft.assertAll();
    }


    public void removeFeedTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.set_text(search, "AnkitEditFeedAutomation");
        ActionUtils.waitFor(5);
        ActionUtils.click(delete);
        ActionUtils.waitFor(5);
        String deleteScreenTitle= ActionUtils.get_text(warningScreenPopUp);
        soft.assertEquals(deleteScreenTitle, "Are you sure you want to DELETE this Feed Template?");
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
        ActionUtils.set_text(search, "AnkitFeedAutomation");
        String verifyDeleteFeedTemplate = ActionUtils.get_text(verifyDeleteFeed);
        System.out.println(verifyDeleteFeedTemplate);
        soft.assertEquals(verifyDeleteFeedTemplate,"No matching records found");
        actionUtils.screenshot();
        soft.assertAll();
    }

    public void removeUsedFeedTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.clear(search);
        ActionUtils.set_text(search, "Ankit test");
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

    public void deactivateUsedFeeTemplate() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.clear(search);
        ActionUtils.set_text(search, "Ankit test");
        ActionUtils.click(edit);
        String editPageHeader = ActionUtils.get_text(pageHeader);
        System.out.println(editPageHeader);
        soft.assertEquals(editPageHeader, "Edit Feed Template: "+"Ankit test");
        ActionUtils.waitFor(3);
        ActionUtils.click(statusToggleButton);
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
