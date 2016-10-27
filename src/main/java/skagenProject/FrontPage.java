package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrontPage {
    WebDriver driver;
    private By menLink = By.cssSelector("a[manual_cm_sp=\"Header-_-Men-_-Men\"]");
    private By titaniumLink = By.cssSelector("a[manual_cm_sp=\"Header-_-Men-_-Watches-Titanium\"");

    public FrontPage(){
        if(driver == null){
            driver = new ChromeDriver();
        }
    }

    public FrontPage(WebDriver driver){
        if(driver == null){
            this.driver = new ChromeDriver();
        }else {
            this.driver = driver;
        }
    }

    public void open(){
        driver.get("http://skagen.com");
    }

    public void chooseTitaniumWatch(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menLink)).build().perform();
        driver.findElement(titaniumLink).click();
    }


}
