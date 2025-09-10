package applicationUtility;

import baselibrary.BaseLibrary;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;

public class ActionUtils extends BaseLibrary
{
    public static void click(WebElement element){
        visibilityOfElement(element);
        element.click();
    }

    public static void set_text(WebElement element, String text){
        visibilityOfElement(element);
        element.sendKeys(text);
    }

    public static void select_by_value(WebElement element, String text){
        visibilityOfElement(element);
        Select sle = new Select(element);
        sle.selectByValue(text);
    }

    public static String get_text(WebElement element){
        visibilityOfElement(element);
        String text = element.getText();
        return text;
    }

    public static void visibilityOfElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitFor(int time) throws InterruptedException {

        Thread.sleep(time*1000);
    }

    public static void scroll_till_element(WebElement element) throws InterruptedException {

        visibilityOfElement(element);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        waitFor(3);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void set_value (WebElement ele, String text){
        visibilityOfElement(ele);
        String script = "arguments[0].value = arguments[1]";
        ((JavascriptExecutor) driver).executeScript(script,ele, text);
    }

    public static void clear(WebElement element){
        element.clear();
    }

    public static void scroll_till_bottom_page(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void selectRecordPerPage(WebElement ele, String pageSize){
        ActionUtils.select_by_value(ele, pageSize);
    }

    public static void verifyToolTipValue(WebElement element, String verifyText){
        SoftAssert soft = new SoftAssert();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String Text = element.getAttribute("data-bs-original-title");
        soft.assertEquals(Text,verifyText);
        soft.assertAll();
    }

    public static void verifyDownloadCSVFile(WebElement ele, String downloadPath) throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        click(ele);
        ActionUtils.waitFor(5);
        File csvFile = getLatestFile(downloadPath);
        if (csvFile != null && csvFile.getName().endsWith(".csv")) {
            System.out.println("CSV downloaded: " + csvFile.getName());
            if (csvFile.delete()) {
                System.out.println("CSV deleted successfully.");
            } else {
                System.out.println("CSV deletion failed!");
            }
        } else {
            soft.fail("CSV file not downloaded!");
        }
        soft.assertAll();
    }

    public static void verifyDownloadXLSXFile(WebElement ele, String downloadPath) throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        click(ele);
        ActionUtils.waitFor(5);
        File xlsxFile = getLatestFile(downloadPath);
        if (xlsxFile != null && xlsxFile.getName().endsWith(".xlsx")) {
            System.out.println("XLSX downloaded: " + xlsxFile.getName());
            if (xlsxFile.delete()) {
                System.out.println("XLSX deleted successfully.");
            } else {
                System.out.println("XLSX deletion failed!");
            }
        } else {
            soft.fail("XLSX file not downloaded!");
        }
        soft.assertAll();
    }

    public static File getLatestFile(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        return Arrays.stream(files)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }
}
