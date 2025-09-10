package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvertiserDashboardPage extends BaseLibrary
{
    public AdvertiserDashboardPage(){
        PageFactory.initElements(driver,this);
    }
    ActionUtils actionUtils = new ActionUtils();

    @FindBy(xpath = "//ul//li//a[@href='https://"+env+".pheonix.paktolus.io/admin/advertisement/advertiser']")
    WebElement dashboard;
    @FindBy(xpath = "//h1[contains(text(),'Advertiser Dashboard')]")
    WebElement advertiserPageHeader;
    @FindBy(xpath = "//select[@class='form-control input-sm']")
    public static WebElement recordPerPage;
    @FindBy(xpath = "//div[@class='dataTables_info']")
    WebElement totalCount;
    @FindBy(xpath = "//div[@class='toggle-switch']")
    WebElement activeOnlyToggle;
    @FindBy(xpath = "//a[@class='export-advertise-csv']")
    WebElement csvButton;
    @FindBy(xpath = "//a[@class='export-advertise-excel']")
    WebElement xlsxButton;

    public void advertiserDashboard() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.waitFor(3);
        ActionUtils.click(dashboard);
        String pageHeader = ActionUtils.get_text(advertiserPageHeader);
        soft.assertEquals(pageHeader,"Advertiser Dashboard");
        if(pageHeader.equals("Advertiser Dashboard")){
            System.out.println("User is land on Advertiser Dashboard page of Dealer Alchemist "+pageHeader);
            actionUtils.screenshot();
        }
        else{
            System.out.println("User is not on Advertiser Dashboard page of Dealer Alchemist");
            actionUtils.screenshot();
        }
        ActionUtils.waitFor(3);
        ActionUtils.selectRecordPerPage(recordPerPage,"100");
        ActionUtils.waitFor(5);
        ActionUtils.verifyDownloadCSVFile(csvButton, fileDownloadPath);
        ActionUtils.verifyDownloadXLSXFile(xlsxButton, fileDownloadPath);
        matchActiveAdvertisersCount();
        verifyColumnName();
        matchInactiveAdvertisersCount();
        addAdvertiser();
        soft.assertAll();
    }


    public void matchActiveAdvertisersCount(){
        SoftAssert soft = new SoftAssert();
        List<WebElement> rowList = driver.findElements(By.xpath("//tbody//tr"));
//        for(int i =0;i<rowList.size();i++){
//            rowList.get(i).getText();
//        }
        int rowCount = rowList.size();
        int totalAdvertiserCount = Integer.parseInt(ActionUtils.get_text(totalCount).split(" ")[5]);
        soft.assertEquals(rowCount,totalAdvertiserCount);
        if(rowCount==totalAdvertiserCount){
            System.out.println("Active Advertisers count is matching on Advertiser dashboard page. "+ totalAdvertiserCount);
            actionUtils.screenshot();
        }
        else {
            System.out.println("Active Advertisers count is not matching on Advertiser dashboard page");
            actionUtils.screenshot();
        }
        soft.assertAll();
    }

    public void verifyColumnName(){
        SoftAssert soft = new SoftAssert();
        List<WebElement> columnCount = driver.findElements(By.xpath("//thead//tr//th"));
        List<String> columnNames = new ArrayList<>();
        for (int i=0; i<columnCount.size(); i++){
            String columnName = columnCount.get(i).getText();
            columnNames.add(columnName);
        }
        List<String> expectedColumnNames = Arrays.asList("Advertiser Name", "Total Active Feed Records","Last Update", "History", "Custom Feeds", "CMS", "Actions");
        soft.assertEquals(columnNames,expectedColumnNames);
        System.out.println("Total Column is: "+columnCount.size());
        System.out.println(columnNames);
        soft.assertAll();
    }

    public void matchInactiveAdvertisersCount() throws InterruptedException {
        ActionUtils.click(activeOnlyToggle);
        ActionUtils.waitFor(3);
        actionUtils.screenshot();
        SoftAssert soft = new SoftAssert();
        List<WebElement> rowList = driver.findElements(By.xpath("//tbody//tr"));
        for(int i =0;i<rowList.size();i++){
            rowList.get(i).getText();
        }
        int rowCount = rowList.size();
        int totalAdvertiserCount = Integer.parseInt(ActionUtils.get_text(totalCount).split(" ")[5]);
        soft.assertEquals(rowCount,totalAdvertiserCount);
        if(rowCount==totalAdvertiserCount){
            System.out.println("Inactive Advertisers count is matching on Advertiser dashboard page. "+ totalAdvertiserCount);
        }
        else {
            System.out.println("Inactive Advertisers count is not matching on Advertiser dashboard page");
        }
        ActionUtils.waitFor(3);
        ActionUtils.click(activeOnlyToggle);
        soft.assertAll();
    }

    @FindBy(xpath = "//a[@id='add-new-advertiser']")
    WebElement addAdvertiserButton;
    @FindBy(xpath = "//h3[@class='page-header']")
    WebElement pageHeader;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    WebElement selectHighlightedText;
    @FindBy(xpath = "//label[contains(text(),'Store Name')]//following-sibling::span//span[@id='select2-advertiser_rooftop_id-container']")
    WebElement storeName;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    WebElement dropdownSearch;
    @FindBy(xpath = "//label[contains(text(),'CMS Format')]//following-sibling::span//span[@id='select2-advertiser_cms-container']")
    WebElement cmsFormat;
    @FindBy(xpath = "//label[contains(text(),'SRP URL')]//following-sibling::span//span[@class='select2-selection select2-selection--multiple']")
    WebElement SRP_URL;
    @FindBy(xpath = "//form//div//label//i")
    WebElement SRP_URLToolTip;
    @FindBy(xpath = "//div[@class='modal-header']//h4[@id='modalTitle']")
    WebElement modalTitle;
    @FindBy(xpath = "//button[@class='close ms-auto']//span")
    WebElement crossModal;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okButton;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//div[@id='swal2-html-container']")
    WebElement confirmScreenTitle;
    @FindBy(xpath = "//button[@id='addSrpRow']")
    WebElement addSRP_URLButton;
    @FindBy(xpath = "//input[@placeholder='Label']")
    WebElement label;
    @FindBy(xpath = "//input[@placeholder='Url']")
    WebElement Url;
    @FindBy(xpath = "//button[@id='saveSrpUrl']")
    WebElement saveUrlButton;
    @FindBy(xpath = "//h3[@class='page-header']//a")
    WebElement backButton;
    @FindBy(xpath = "(//td[@class='text-center align-middle']/i)[2]")
    WebElement removeSecondSRPUrl;


    public void addAdvertiser(){
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(addAdvertiserButton);
        String pageTitle = ActionUtils.get_text(pageHeader);
        soft.assertEquals(pageTitle, "Add Advertiser");
        ActionUtils.click(storeName);
        ActionUtils.set_text(dropdownSearch, "TEST Function");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.verifyToolTipValue(SRP_URLToolTip, "Enter multiple URLs, each will appear as a tag. Click on the field to display a modal for adding, editing, or removing URLs.");
        ActionUtils.click(SRP_URL);
        String modalTitleValue = ActionUtils.get_text(modalTitle);
        soft.assertEquals(modalTitleValue, "Add SRP URL");
        ActionUtils.click(crossModal);
        String modal2TitleValue = ActionUtils.get_text(confirmScreenTitle);
        soft.assertEquals(modal2TitleValue, "This will discard all unsaved changes.");
        ActionUtils.click(okButton);
        ActionUtils.click(SRP_URL);
        ActionUtils.click(crossModal);
        ActionUtils.click(cancelButton);
        ActionUtils.click(addSRP_URLButton);
        ActionUtils.set_text(label,"Automation");
        ActionUtils.set_text(Url,"https://www.alexanderbgc.com/searchnew.aspx");
        ActionUtils.click(saveUrlButton);
        ActionUtils.click(SRP_URL);
        ActionUtils.click(addSRP_URLButton);
        ActionUtils.click(removeSecondSRPUrl);
        ActionUtils.click(saveUrlButton);
        ActionUtils.click(cmsFormat);
        ActionUtils.set_text(dropdownSearch, "Auto Go");
        ActionUtils.click(selectHighlightedText);
        ActionUtils.click(backButton);
    }

//    @FindBy(xpath = "//label[contains(text(),'Store:')]//following-sibling::form//span[@role='combobox']")
//    WebElement storeDropdown;
//    @FindBy(xpath = "(//label[@id='social']//..//following-sibling::div//span[@class='num-lbl'])[1]")
//    WebElement socialImpressions;
//    public void verifyStoreName() throws InterruptedException {
//        ActionUtils.waitFor(3);
////        ActionUtils.click(dashboard);
//        ActionUtils.click(storeDropdown);
//        List<WebElement> storeList = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
//        System.out.println("Total Store Available="+ storeList.size());
//        for (int i=0; i<=storeList.size()-1;i++){
//            List<WebElement> storeList2 = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
//            String StoreName = storeList2.get(i).getText();
////            System.out.println("Store name = "+StoreName);
//            storeList2.get(i).click();
//            ActionUtils.waitFor(5);
//            List<WebElement> platfromList = driver.findElements(By.xpath("//ul//li[@class='nav-item']//a"));
////            System.out.println("platform count = "+ platfromList.size());
//            for (int j=0; j<=platfromList.size()-1; j++){
//                String platformName = platfromList.get(j).getText();
//                if(platformName.equals("Social")){
//                    platfromList.get(j).click();
//                    ActionUtils.waitFor(5);
//                    long socialImpressionsCount = Long.parseLong(ActionUtils.get_text(socialImpressions).replaceAll(",",""));
//                    if(socialImpressionsCount==0){
//                        System.out.println("Store name: " + StoreName + " | Social Impressions: " + socialImpressionsCount);
//                    }
//                }
//            }
//            ActionUtils.click(storeDropdown);
//        }
//    }
}
