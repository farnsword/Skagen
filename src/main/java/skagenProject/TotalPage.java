package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalPage {
    WebDriver driver;
    private By subTotalPrice = By.cssSelector("#subTotalVal");

    public TotalPage() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    public TotalPage(WebDriver driver) {
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }
    }

    public String getSubTotalValue(){
        return driver.findElement(subTotalPrice).getText();
    }
}
