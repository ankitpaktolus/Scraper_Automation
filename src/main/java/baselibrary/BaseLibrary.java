package baselibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class BaseLibrary
{

    public static WebDriver driver;
    public static final String env = "staging";
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
//        driver.get("https://insights.dealeralchemist.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }
}
