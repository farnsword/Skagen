package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoosenWatchPage {
    WebDriver driver;
    private By buyButton = By.cssSelector("button#add-to-bag");
    private By countinueShoppingLink = By.xpath(".//a[@manual_cm_sp=\"Header-_-MiniCart-_-Continue Shopping\"]");
    private By price = By.xpath(".//div[@class=\"product-price col-md-12\"]");

    public ChoosenWatchPage() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    public ChoosenWatchPage(WebDriver driver) {
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }
    }

    public void clickAddButton() {
        driver.findElement(buyButton).click();
    }

    public void continueShopping() {
        WebElement waiting = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(countinueShoppingLink));
        driver.findElement(countinueShoppingLink).click();
    }

    public int getPrice(){
        String text = driver.findElement(price).getText().substring(1, 4);
        return Integer.parseInt(text);
    }

    public boolean checkPrice(int expectedPrice) {
        String pr = new String();
        pr += expectedPrice;
        boolean result = driver.findElement(price).getText().contains(pr);
        return result;
    }
}
