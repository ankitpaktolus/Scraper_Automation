package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
import excelUtility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class LoginPage extends BaseLibrary
{

    ActionUtils actionUtils = new ActionUtils();
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Login into your account')]")
    WebElement verifyLoginPage;
    @FindBy(xpath = "//a[contains(text(),'Did you forget your password?')]")
    WebElement forgetPassword;
    @FindBy(xpath = "//div[contains(text(),'Reset password')]")
    WebElement verifyResetPage;
    @FindBy(xpath = "//button[contains(text(),' Send email ')]")
    WebElement sendEmail;
    @FindBy(xpath = "//LI[contains(text(),'The email does not exist.')]")
    WebElement resetPageError;
    @FindBy(xpath = "//img[@src='https://alfosv2-dev.americasleading.com/alf_images/arrow_left_alt.svg']")
    WebElement goBack;
    @FindBy(xpath = "//input[@type='email']")
    WebElement userName;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//li[@class='dropdown language language-menu']")  ////div[@class='profile-details']//..//..//..//a[@class='dropdown-toggle']
    WebElement change_language;
    @FindBy(xpath = "//a[contains(text(),'EN')]")
    WebElement english;
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement Home;
    @FindBy(xpath = "//tbody//tr//td[@class='sorting_1']")
    WebElement AdvertiserName;
    @FindBy(xpath = "//li[contains(text(),'Email not found. Please contact support team for further assistance.')]")
    WebElement loginError;
    @FindBy(xpath = "//h1[contains(text(),'Create Finance Application')]")
    WebElement verifyApplicationPage;
    @FindBy(xpath = "(//a[@class='menu-link'])[4]") //(//ul[@class='treeview-menu  menu-open']//li[2])
    WebElement create_application;
    @FindBy(xpath = "//li[@class='dropdown dropdown-width']")
    WebElement userProfile;
    @FindBy(xpath = "//i[@class='fa fa-sign-out fa-fw']")
    WebElement logout;
    @FindBy(xpath = " //span[contains(text(),'Advertisement')]")
    WebElement advertisement;
    @FindBy(xpath = "(//ul[@class= 'treeview-menu   menu-open']//li//a)[1]")
    WebElement advertiserDashboard;
    @FindBy(xpath = "//tbody//tr//td//div[@class ='org-span gap-12']//a[@aria-label='Feeds']")
    WebElement feed;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement Search;
//    WebElement Search= driver.findElement(By.xpath("//input[@placeholder='Search']"));
    @FindBy(xpath = "//p[contains(text(),'Total Active Feed Records')]//..//p[@class='feed-number text-center']")
    WebElement totalActiveRecords;
    @FindBy(xpath = "//img[@aria-label='Advertiser Inventory']")
    WebElement ViewInventory;


    public void deleteAllure(){
        String pathFolder = "C:\\Project\\DA\\ALF\\allure-results";

        File folder = new File(pathFolder);
        if(folder.exists()){
            boolean deletionResult = deleteFolder(folder);
            if(deletionResult) {
                System.out.println("Allure Report Folder deleted successfully.");
            }
            else {
                System.out.println("Failed to delete the folder.");
            }
        }
        else {
            System.out.println("Folder does not exist.");
        }
    }

    private boolean deleteFolder(File folder) {

        if(folder.isDirectory()){
            File[] files = folder.listFiles();
            if(files != null){
                for(File file: files ){
                    if (!deleteFolder(file)) {
                        return false;
                    }
                }
            }
        }
        return folder.delete();
    }

    public void forgetPassword(){
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(change_language);
        ActionUtils.click(english);
        ActionUtils.click(forgetPassword);
        String screen_title = ActionUtils.get_text(verifyResetPage);
        soft.assertEquals(screen_title,"Reset password");
        ActionUtils.set_text(userName, ExcelUtility.excel("Login",0));
        ActionUtils.click(sendEmail);
        String pageError = ActionUtils.get_text(resetPageError);
        soft.assertEquals(pageError,"The email does not exist.");
        actionUtils.screenshot();
        ActionUtils.click(goBack);
        soft.assertAll();
    }

    public void inputUserInValidLogin(){
        SoftAssert soft = new SoftAssert();
        String screen_title = ActionUtils.get_text(verifyLoginPage);
        soft.assertEquals(screen_title,"Login into your account");
        ActionUtils.set_text(userName, ExcelUtility.excel("Login",0));
        ActionUtils.set_text(password, ExcelUtility.excel("Login",2));
        ActionUtils.click(submit);
        String page_error = ActionUtils.get_text(loginError);
        soft.assertEquals(page_error,"Email not found. Please contact support team for further assistance.");
        soft.assertAll();
    }

    public void inputUserValidLogin(){
        SoftAssert soft = new SoftAssert();
        actionUtils.screenshot();
        ActionUtils.set_text(userName, "andrew@dealeralchemist.com");
        ActionUtils.set_text(password, "R0@$7263GGat");
        ActionUtils.click(submit);
        String homePage = ActionUtils.get_text(Home);
        soft.assertEquals(homePage,"Home");
        soft.assertAll();
    }

    public void clickOnAdvertisement() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        ActionUtils.click(advertisement);
        ActionUtils.waitFor(2);
        soft.assertAll();
    }

//    public void logOut() throws InterruptedException {
//        ActionUtils.visibilityOfElement(userProfile);
//        ActionUtils.scroll_till_element(userProfile);
//        ActionUtils.click(userProfile);
//        ActionUtils.click(logout);
//        System.out.println("Logout successfully");
//    }
}
