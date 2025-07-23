package HamleysAutomationScripts;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            FileHandler.copy(screenshot, new File("screenshots/" + fileName + "_" + timestamp + ".png"));
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}
