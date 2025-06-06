package scraperPages;

import applicationUtility.ActionUtils;
import baselibrary.BaseLibrary;
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

    @FindBy(xpath = "//input[@type='email']")
    WebElement userName;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement Home;
    @FindBy(xpath = "//li[@class='dropdown dropdown-width']")
    WebElement userProfile;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement logout;
    @FindBy(xpath = " //span[contains(text(),'Advertisement')]")
    WebElement advertisement;

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
