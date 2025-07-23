package HamleysAutomationScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Set up Chrome browser options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--disable-notifications", "--disable-popup-blocking", "--no-first-run");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            // Set up Edge browser options
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--no-first-run");
            driver = new EdgeDriver(options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
