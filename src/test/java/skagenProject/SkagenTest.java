package skagenProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SkagenTest {
    static WebDriver driver;

    @Before
    public void preCondition(){
        System.setProperty("webdriver.chrome.driver", "/home/oleksii/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void SkagenPurchasingTest(){
        int totalPrice = 0;
        FrontPage front = new FrontPage(driver);
        front.open();
        front.chooseTitaniumWatch();

        MensTitaniumPage watchesPage = new MensTitaniumPage(driver);
        Assert.assertEquals("Titanium", watchesPage.getTextForAssert());
        watchesPage.chooseMenWatch();

        ChoosenWatchPage choosenWatch = new ChoosenWatchPage(driver);
        Assert.assertTrue(choosenWatch.checkPrice(219));
        totalPrice += choosenWatch.getPrice();
        System.out.println(totalPrice);
        choosenWatch.clickAddButton();
        choosenWatch.continueShopping();

        MensBagsPage bags = new MensBagsPage(driver);
        bags.openMensBags();
        Assert.assertEquals("Backpacks & Travel Bags", bags.getTextForAssert());
        bags.chooseABag();

        ChoosenBagPage aBag = new ChoosenBagPage(driver);
        Assert.assertTrue(aBag.checkPrice(279));
        aBag.chooseNumberOfBags(3);
        totalPrice += aBag.getPrice();
        System.out.println(totalPrice);
        aBag.clickAddButton();
        aBag.clickCheckoutButton();

        TotalPage total = new TotalPage(driver);
        String countedTotal = new String();
        countedTotal += totalPrice;
        countedTotal = countedTotal.charAt(0) + "," + countedTotal.substring(1);
        System.out.println(countedTotal);
        Assert.assertTrue(total.getSubTotalValue().contains(countedTotal));
    }

    @After
    public void postCondition(){
        driver.close();
    }
}
