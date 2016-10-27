package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoosenBagPage {
    WebDriver driver;
    private int quantity = 1;
    private By buyButton = By.cssSelector("button#add-to-bag");
    private By checkoutLink = By.xpath(".//a[@manual_cm_sp=\"Header-_-MiniCart-_-Checkout\"]");
    private By price = By.xpath(".//div[@class=\"product-price col-md-12\"]");

    public ChoosenBagPage() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    public ChoosenBagPage(WebDriver driver) {
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }
    }

    public void chooseNumberOfBags(int n) {
        quantity = n;
        String js = "document.getElementById(\"product-quantity\").value=" + n + ";";
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(js);
        } else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
    }

    public void clickAddButton() {
        driver.findElement(buyButton).click();
    }

    public void clickCheckoutButton() {
        WebElement waiting = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(checkoutLink));
        driver.findElement(checkoutLink).click();
    }

    public int getPrice() {
        String text = driver.findElement(price).getText().substring(1, 4);
        return Integer.parseInt(text) * quantity;
    }

    public boolean checkPrice(int expectedPrice) {
        String pr = new String();
        pr += expectedPrice;
        boolean result = driver.findElement(price).getText().contains(pr);
        return result;
    }

}
