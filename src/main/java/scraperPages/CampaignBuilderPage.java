package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CampaignBuilderPage extends BaseLibrary {

    ActionUtils actionUtils = new ActionUtils();
    AdvertiserDashboardPage fill = new AdvertiserDashboardPage();

    public CampaignBuilderPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//ul//li//a[@href='https://"+env+".pheonix.paktolus.io/admin/campaign']")
    WebElement campaignBuilder;
    @FindBy(xpath = "//h1[contains(text(),'Campaign Builder')]")
    WebElement campaign_builder_header_title;
    @FindBy(xpath = "//a[contains(text(), 'Auto-Templates')]")
    WebElement autoTemplate;
    @FindBy(xpath = "//a[contains(text(), 'Negative Keywords')]")
    WebElement negativeKeyword;
    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement negative_keyword_header_title;
    @FindBy(xpath = "//a[@class='btn-add-new-store ']")
    WebElement createNewKeywordList;
    @FindBy(xpath = "//h3[@class='page-header']")
    WebElement create_negative_keyword_header_title;

    @FindBy(xpath = "//input[@placeholder='Negative List Name']")
    WebElement negativeListName;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addKeywordButton;
    @FindBy(xpath = "//input[@name='keyword[0]']")
    WebElement addKeyword1;
    @FindBy(xpath = "//input[@name='keyword[1]']")
    WebElement addKeyword2;
    @FindBy(xpath = "//input[@name='keyword[2]']")
    WebElement addKeyword3;
    @FindBy(xpath = "//input[@name='keyword[3]']")
    WebElement addKeyword4;
    @FindBy(xpath = "//select[@name='keywordMatchType[0]']")
    WebElement selectMatchType1;
    @FindBy(xpath = "//select[@name='keywordMatchType[1]']")
    WebElement selectMatchType2;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;
    @FindBy(xpath = "//input[@name='keywordPin[3]']//..//..//following-sibling::i")
    WebElement removeKeyword4;
    @FindBy(xpath = "//input[@type='search']")
    WebElement search;
    @FindBy(xpath = "//a[@aria-label='Edit']")
    WebElement editNegativeKeywordLists;
    @FindBy(xpath = "//h3[@class='page-header']")
    WebElement Edit_Negative_keyword_header_title;
    @FindBy(xpath = "//a[@aria-label='Clone']")
    WebElement cloneNegativeKeywordLists;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//a[@aria-label='Delete']")
    WebElement deleteNegativeKeywordLists;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement confirmDelete;
    @FindBy(xpath = "//h4[contains(text(),'Confirm Delete')]//following-sibling::button")
    WebElement crossIcon;
    @FindBy(xpath = "//a[@class='link']//img")
    WebElement backButton;

    public void campaignDashboard() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(campaignBuilder);
        String campaignHeader = ActionUtils.get_text(campaign_builder_header_title);
        System.out.println(campaignHeader);
        soft.assertEquals(campaignHeader,"Campaign Builder");
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(autoTemplate);
        ActionUtils.click(autoTemplate);
        soft.assertAll();
    }

    public void createNegativeKeywordList() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(negativeKeyword);
        String keywordHeader = ActionUtils.get_text(negative_keyword_header_title);
        System.out.println(keywordHeader);
        soft.assertEquals(keywordHeader,"Negative Keyword Lists");
        actionUtils.screenshot();
        ActionUtils.click(createNewKeywordList);
        ActionUtils.waitFor(2);
        String createKeywordHeader = ActionUtils.get_text(create_negative_keyword_header_title);
        System.out.println(createKeywordHeader);
        soft.assertEquals(createKeywordHeader,"Create Negative Keywords List");
        ActionUtils.set_text(negativeListName,"Automation Negative Keyword");
        ActionUtils.scroll_till_element(addKeywordButton);
        ActionUtils.click(addKeywordButton);
        ActionUtils.set_text(addKeyword1,"Automation keyword 1");
        ActionUtils.select_by_value(selectMatchType1,"exact");
        ActionUtils.click(addKeywordButton);
        ActionUtils.set_text(addKeyword2,"Automation keyword 2");
        ActionUtils.select_by_value(selectMatchType2, "broad");
        ActionUtils.click(addKeywordButton);
        ActionUtils.set_text(addKeyword3,"Automation keyword 3");
        ActionUtils.click(addKeywordButton);
        ActionUtils.set_text(addKeyword4,"Automation keyword 4");
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        soft.assertAll();
    }

    public void editNegativeKeywordList() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(2);
        ActionUtils.set_text(search, "Automation Negative Keyword");
        ActionUtils.click(editNegativeKeywordLists);
        String editKeywordHeader = ActionUtils.get_text(Edit_Negative_keyword_header_title);
        System.out.println(editKeywordHeader);
        soft.assertEquals(editKeywordHeader,"Edit Negative Keywords List");
        actionUtils.screenshot();
        ActionUtils.clear(negativeListName);
        ActionUtils.set_text(negativeListName,"Edit Automation Negative Keyword");
        ActionUtils.clear(addKeyword1);
        ActionUtils.set_text(addKeyword1,"Edit Automation keyword 1");
        ActionUtils.select_by_value(selectMatchType1,"broad");
        ActionUtils.scroll_till_element(removeKeyword4);
        ActionUtils.click(removeKeyword4);
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        soft.assertAll();
    }

    public void cloneNegativeKeywordList() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(2);
        ActionUtils.set_text(search, "Edit Automation Negative Keyword");
        ActionUtils.waitFor(2);
        ActionUtils.click(cloneNegativeKeywordLists);
        ActionUtils.waitFor(5);
        actionUtils.screenshot();
        ActionUtils.clear(search);
        ActionUtils.waitFor(2);
        ActionUtils.set_text(search, "Edit Automation Negative Keyword (copy)");
        ActionUtils.click(editNegativeKeywordLists);
        ActionUtils.waitFor(2);
        ActionUtils.scroll_till_element(cancelButton);
        ActionUtils.click(cancelButton);
        ActionUtils.waitFor(5);
        ActionUtils.set_text(search, "Edit Automation Negative Keyword (copy)");
        ActionUtils.click(deleteNegativeKeywordLists);
        ActionUtils.click(confirmDelete);
        ActionUtils.waitFor(5);
        ActionUtils.clear(search);
        soft.assertAll();
    }

    public void deleteNegativeKeywordList() throws InterruptedException {
        ActionUtils.waitFor(2);
        ActionUtils.set_text(search, "Edit Automation Negative Keyword");
        ActionUtils.waitFor(2);
        ActionUtils.click(deleteNegativeKeywordLists);
        actionUtils.screenshot();
        ActionUtils.waitFor(2);
        ActionUtils.click(crossIcon);
        ActionUtils.waitFor(2);
        ActionUtils.click(deleteNegativeKeywordLists);
        ActionUtils.waitFor(2);
        ActionUtils.click(cancelButton);
        ActionUtils.waitFor(2);
        ActionUtils.click(deleteNegativeKeywordLists);
        ActionUtils.click(confirmDelete);
        ActionUtils.waitFor(2);
        ActionUtils.clear(search);
        ActionUtils.waitFor(2);
        ActionUtils.click(backButton);
    }

    @FindBy(xpath = "//a[contains(text(), 'Product Alias')]")
    WebElement productAlias;
    @FindBy(xpath = "//h3[@class='page-header']")
    WebElement product_Alias_header_title;
    @FindBy(xpath = "//div[contains(text(), 'Make')]")
    WebElement makeAlias;
    @FindBy(xpath = "//h1[contains(text(), 'Make')]//following-sibling::button")
    WebElement addMake;
    @FindBy(xpath = "//input[@name='mappings[make][0][value]']")
    WebElement makeValue1;
    @FindBy(xpath = "//input[@name='mappings[make][1][value]']")
    WebElement makeValue2;
    @FindBy(xpath = "//input[@name='mappings[make][0][alias]']")
    WebElement makeAlias1;
    @FindBy(xpath = "//input[@name='mappings[make][1][alias]']")
    WebElement makeAlias2;
    @FindBy(xpath = "//div[contains(text(), 'Model')]")
    WebElement modelAlias;
    @FindBy(xpath = "//h1[contains(text(), 'Model')]//following-sibling::button")
    WebElement addModel;
    @FindBy(xpath = "//input[@name='mappings[model][0][value]']")
    WebElement modelValue1;
    @FindBy(xpath = "//input[@name='mappings[model][1][value]']")
    WebElement modelValue2;
    @FindBy(xpath = "//input[@name='mappings[model][0][alias]']")
    WebElement modelAlias1;
    @FindBy(xpath = "//input[@name='mappings[model][1][alias]']")
    WebElement modelAlias2;
    @FindBy(xpath = "//div[contains(text(), 'Trim')]")
    WebElement trimAlias;
    @FindBy(xpath = "//h1[contains(text(), 'Trim')]//following-sibling::button")
    WebElement addTrim;
    @FindBy(xpath = "//input[@name='mappings[trim][0][value]']")
    WebElement trimValue1;
    @FindBy(xpath = "//input[@name='mappings[trim][1][value]']")
    WebElement trimValue2;
    @FindBy(xpath = "//input[@name='mappings[trim][0][alias]']")
    WebElement trimAlias1;
    @FindBy(xpath = "//input[@name='mappings[trim][1][alias]']")
    WebElement trimAlias2;

    public void addProductAlias() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.scroll_till_element(autoTemplate);
        ActionUtils.click(autoTemplate);
        ActionUtils.waitFor(3);
        ActionUtils.click(productAlias);
        String productAliasHeader = ActionUtils.get_text(product_Alias_header_title);
        System.out.println(productAliasHeader);
        soft.assertEquals(productAliasHeader,"Product Alias");
        actionUtils.screenshot();
        addMakeAlias();
        addModelAlias();
        addTrimAlias();
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        soft.assertAll();
    }

    public void addMakeAlias() throws InterruptedException {
        ActionUtils.scroll_till_element(makeAlias);
        ActionUtils.click(makeAlias);
        ActionUtils.click(addMake);
        ActionUtils.set_text(makeValue1, "Honda");
        ActionUtils.set_text(makeAlias1, "Hon");
        ActionUtils.waitFor(3);
        ActionUtils.click(addMake);
        ActionUtils.set_text(makeValue2, "Hyundai");
        ActionUtils.set_text(makeAlias2, "Hyn");
        actionUtils.screenshot();

    }

    public void addModelAlias() throws InterruptedException {
        ActionUtils.scroll_till_element(modelAlias);
        ActionUtils.click(modelAlias);
        ActionUtils.click(addModel);
        ActionUtils.set_text(modelValue1, "CR-V Hybrid");
        ActionUtils.set_text(modelAlias1, "CRV");
        ActionUtils.waitFor(3);
        ActionUtils.click(addModel);
        ActionUtils.set_text(modelValue2, "Verna");
        ActionUtils.set_text(modelAlias2, "Vrn");
        actionUtils.screenshot();

    }

    public void addTrimAlias() throws InterruptedException {
        ActionUtils.scroll_till_element(trimAlias);
        ActionUtils.click(trimAlias);
        ActionUtils.click(addTrim);
        ActionUtils.set_text(trimValue1, "HYBRID Sport-L");
        ActionUtils.set_text(trimAlias1, "Sport");
        ActionUtils.waitFor(3);
        ActionUtils.click(addTrim);
        ActionUtils.set_text(trimValue2, "Hatchback Hybrid Sport");
        ActionUtils.set_text(trimAlias2, "Hatchback");
        actionUtils.screenshot();

    }

    @FindBy(xpath = "//input[@name='mappings[make][0][alias]']//..//following-sibling::div//i")
    WebElement removeMake1;
    @FindBy(xpath = "//input[@name='mappings[model][0][alias]']//..//following-sibling::div//i")
    WebElement removeModel1;
    @FindBy(xpath = "//input[@name='mappings[trim][0][alias]']//..//following-sibling::div//i")
    WebElement removeTrim1;
    @FindBy(xpath = "//input[@name='mappings[make][1][alias]']//..//following-sibling::div//i")
    WebElement removeMake2;
    @FindBy(xpath = "//input[@name='mappings[model][1][alias]']//..//following-sibling::div//i")
    WebElement removeModel2;
    @FindBy(xpath = "//input[@name='mappings[trim][1][alias]']//..//following-sibling::div//i")
    WebElement removeTrim2;

    public void editProductAlias() throws InterruptedException {
        ActionUtils.scroll_till_element(makeAlias);
        ActionUtils.click(makeAlias);
        ActionUtils.clear(makeValue1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(makeValue1, "Honda Edit");
        ActionUtils.clear(makeAlias1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(makeAlias1, "Hon Edit");
        ActionUtils.waitFor(3);
        ActionUtils.click(removeMake2);
        ActionUtils.scroll_till_element(modelAlias);
        ActionUtils.click(modelAlias);
        ActionUtils.clear(modelValue1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(modelValue1, "CR-V Hybrid");
        ActionUtils.clear(modelAlias1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(modelAlias1, "CRV Edit");
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        ActionUtils.click(removeModel2);
        ActionUtils.scroll_till_element(trimAlias);
        ActionUtils.click(trimAlias);
        ActionUtils.clear(trimValue1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(trimValue1, "HYBRID Sport-L Edit");
        ActionUtils.clear(trimAlias1);
        ActionUtils.waitFor(3);
        ActionUtils.set_text(trimAlias1, "Sport Edit");
        ActionUtils.waitFor(3);
        ActionUtils.click(removeTrim2);
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
    }

    public void removeAllProductAlias() throws InterruptedException {
        ActionUtils.scroll_till_element(makeAlias);
        ActionUtils.click(makeAlias);
        ActionUtils.waitFor(3);
        ActionUtils.click(removeMake1);
        ActionUtils.click(makeAlias);
        ActionUtils.scroll_till_element(modelAlias);
        ActionUtils.click(modelAlias);
        ActionUtils.waitFor(3);
        ActionUtils.click(removeModel1);
        ActionUtils.click(modelAlias);
        ActionUtils.scroll_till_element(trimAlias);
        ActionUtils.click(trimAlias);
        ActionUtils.waitFor(3);
        ActionUtils.click(removeTrim1);
        ActionUtils.click(trimAlias);
        actionUtils.screenshot();
        ActionUtils.scroll_till_element(submitButton);
        ActionUtils.click(submitButton);
        ActionUtils.waitFor(3);
        ActionUtils.scroll_till_element(backButton);
        ActionUtils.click(backButton);
    }
}
