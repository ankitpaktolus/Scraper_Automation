package baselibrary;

import applicationUtility.ActionUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class BaseLibrary
{

    public static WebDriver driver;
    public static final String env = "staging";
    public static String fileDownloadPath = "C:\\Users\\AnkitKumar\\Downloads";
    public void getLaunchUrl(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome is Launched ");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firebox is Launched ");
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge Browser is Launched ");
        }
        driver.get("https://"+env+".pheonix.paktolus.io/login");
//        driver.get("https://automationexercise.com/");
//        driver.get("https://insights.dealeralchemist.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }

    @AfterSuite
    public void openAllureReport() {
        try {
            String allurePath = "C:\\Users\\AnkitKumar\\Downloads\\allure-commandline-2.9.0\\allure-2.9.0\\bin\\allure.bat";
            String projectPath = "C:\\Project\\DA\\ALF";
            String command = String.format("\"%s\" serve \"%s\\allure-results\"", allurePath, projectPath);
            Process process = Runtime.getRuntime().exec(command);
//            process.waitFor();
            ActionUtils.waitFor(4);
            System.out.println("Allure report launched successfully in browser!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
