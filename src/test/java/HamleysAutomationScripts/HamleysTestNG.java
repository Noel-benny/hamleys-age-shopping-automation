package HamleysAutomationScripts;

import HamleysAutomationScripts.pages.HamleysPage;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class HamleysTestNG extends BaseTest {
    private ExcelUtil excelUtil;
    private String excelPath = "src/test/resources/HamleysData.xlsx";
    private String browserName;

    @Parameters("browser")
    @Test
    public void testHamleysProductCount(@Optional("chrome") String browser) throws Exception {
        this.browserName = browser;
        excelUtil = new ExcelUtil(excelPath);
        String websiteLink = excelUtil.getWebsiteLink();

        driver.get(websiteLink);
        HamleysPage hamleysPage = new HamleysPage(driver, wait);

        hamleysPage.closePopupIfPresent();
        Thread.sleep(2000);
        hamleysPage.scrollToShopByAge();
        Thread.sleep(2000);
        hamleysPage.moveSliderTo12Plus();
        Thread.sleep(2000);
        hamleysPage.click12PlusCategory();
        hamleysPage.sortByPriceLowToHigh();
        hamleysPage.applyPriceFilter();
        hamleysPage.applyInStockFilter();

        int productCount = hamleysPage.getProductCount();
        System.out.println("Total products available: " + productCount);

        hamleysPage.scrollToTop();
        Thread.sleep(3000);
        ScreenshotUtil.takeScreenshot(driver, "hamleys_final_screen_" + browserName);

        excelUtil.writeProductCount(productCount, browserName);
        excelUtil.close();
    }
}
