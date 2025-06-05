package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdvertiserDashboardPage extends BaseLibrary
{
    public AdvertiserDashboardPage(){
        PageFactory.initElements(driver,this);
    }
    ActionUtils actionUtils = new ActionUtils();

    @FindBy(xpath = "//ul//li//a[@href='https://dev.pheonix.paktolus.io/admin/advertisement/advertiser']")
    WebElement dashboard;
    @FindBy(xpath = "//h1[contains(text(),'Advertiser Dashboard')]")
    WebElement advertiserPageHeader;
    @FindBy(xpath = "//select[@class='form-control input-sm']")
    public static WebElement recordPerPage;
    @FindBy(xpath = "//div[@class='dataTables_info']")
    WebElement totalCount;
    @FindBy(xpath = "//div[@class='toggle-switch']")
    WebElement activeOnlyToggle;

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
        matchActiveAdvertisersCount();
        verifyColumnName();
        matchInactiveAdvertisersCount();
        soft.assertAll();
    }


    public void matchActiveAdvertisersCount(){
        SoftAssert soft = new SoftAssert();
        List<WebElement> rowList = driver.findElements(By.xpath("//tbody//tr"));
        for(int i =0;i<rowList.size();i++){
            rowList.get(i).getText();
        }
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
        List<WebElement> columnName = driver.findElements(By.xpath("//thead//tr//th"));
        for(int i =0;i<columnName.size();i++){
            String name = columnName.get(i).getText();
            System.out.println("The column Name is ="+name);
        }
        int columnCount = columnName.size();
        System.out.println("Total column Count = "+columnCount);
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
        soft.assertAll();
        ActionUtils.waitFor(3);
        ActionUtils.click(activeOnlyToggle);
    }

}
