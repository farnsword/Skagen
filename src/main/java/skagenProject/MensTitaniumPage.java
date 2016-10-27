package skagenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MensTitaniumPage {
    WebDriver driver;
    private By choosenWatch = By.xpath(".//a[contains(@title, \"Holst World \")]");
    private By elementForAssert = By.xpath(".//ol[@id=\"breadCrumb\"]/li[3]");

    public MensTitaniumPage(){
        if(driver == null){
            driver = new ChromeDriver();
        }
    }

    public MensTitaniumPage(WebDriver driver){
        if(driver == null){
            this.driver = new ChromeDriver();
        }else {
            this.driver = driver;
        }
    }

    public void chooseMenWatch(){
        driver.findElement(choosenWatch).click();
    }

    public String getTextForAssert(){
        return driver.findElement(elementForAssert).getText();
    }
}
