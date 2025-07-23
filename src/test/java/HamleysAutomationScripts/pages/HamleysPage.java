package HamleysAutomationScripts.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class HamleysPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HamleysPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void closePopupIfPresent() {
        try {
            WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'nvpush_popup_background')]//svg")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", popup);
        } catch (Exception e) {
            // No popup appeared
        }
    }

    public void scrollToShopByAge() {
        WebElement shopByAgeSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h2[contains(text(),'Shop By Age')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", shopByAgeSection);
        System.out.println("Scrolled to Shop By Age section.");
    }

    public void moveSliderTo12Plus() {
    	WebElement sliderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"homePage\"]/div/div[3]/section/div/div/div[1]/div/div[4]/div")));
        //Actions action = new Actions(driver);
        //action.doubleClick(sliderButton).perform();
        Actions move = new Actions(driver);
        move.clickAndHold(sliderButton).moveByOffset(537, 0).release().perform();
        System.out.println("Moved slider to 12+ years.");
        
    }

    public void click12PlusCategory() {
    	WebElement shopByAgeSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Shop By Age')]")));
    	WebElement sliderContainer = shopByAgeSection.findElement(By.xpath("./following-sibling::div"));
        WebElement age12Plus = sliderContainer.findElement(By.xpath("*[@class='by-age-crousal']/div/div/div[7]/div/a/img"));
        age12Plus.click();
    }

    public void sortByPriceLowToHigh() {
        WebElement sortDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("select[data-v-63c86e23]")));
        new Select(sortDropdown).selectByVisibleText("Price (Low to High)");
    }

    public void applyPriceFilter() {
        WebElement priceFilter = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='filter_div_id']/div[8]/div")));
        priceFilter.click();
        WebElement priceOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.partialLinkText("40-50")));
        priceOption.click();
    }

    public void applyInStockFilter() {
        WebElement stockFilter = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='filter_div_id']/div[10]/div")));
        stockFilter.click();
        WebElement stockOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.partialLinkText("in-stock")));
        stockOption.click();
    }

    public int getProductCount() throws InterruptedException {
        WebElement productCountElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id='__layout']/div/div[2]/div/div/div[1]/section[2]/div/div[1]/div[2]/div/div[1]/div/div/p")));
        Thread.sleep(1000); // Wait before reading product count
        String productText = productCountElem.getText();
        String countOnly = productText.replaceAll("\\D+", "");
        return Integer.parseInt(countOnly);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
    }
}
