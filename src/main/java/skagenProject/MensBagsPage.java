package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MensBagsPage {
    WebDriver driver;
    private By menLink = By.cssSelector("a[manual_cm_sp=\"Header-_-Men-_-Men\"]");
    private By bags = By.xpath(".//a[@manual_cm_sp=\"Header-_-Men-_-Bags & Accessories-Backpacks & Travel Bags\"]");
    private By choosenBag = By.cssSelector("a[title^=\"Riis\"]");
    private By elementForAssert = By.xpath(".//ol[@id=\"breadCrumb\"]/li[3]");

    public MensBagsPage(){
        if(driver == null){
            driver = new ChromeDriver();
        }
    }

    public MensBagsPage(WebDriver driver){
        if(driver == null){
            this.driver = new ChromeDriver();
        }else {
            this.driver = driver;
        }
    }

    public void openMensBags(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menLink)).build().perform();
        driver.findElement(bags).click();
    }

    public void chooseABag(){
        driver.findElement(choosenBag).click();
    }

    public String getTextForAssert(){
        return driver.findElement(elementForAssert).getText();
    }
}
