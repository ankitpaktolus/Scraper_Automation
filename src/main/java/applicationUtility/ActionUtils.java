package applicationUtility;

import baselibrary.BaseLibrary;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
}
