package firstHomework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FindArticleByArray {

    WebDriver chrome;

    public final String HOMEPAGE = "http://rus.delfi.lv";

    //To find an article using xPath option. Need full article name in SEARCHEDARTICLE.
    // In IF expression .contains can be changed by .equals
    //public final By ARTICLETITLES = By.xpath(".//*[@class='top2012-title']");

    public final String SEARCHEDARTICLE = "В Москве открыли ЧМ с участием Путина";

    public final By ARTICLETITLES = By.partialLinkText(SEARCHEDARTICLE);


    @Before

    public void createDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");

        chrome = new ChromeDriver();


    }


    @After

    public void closeBrowser() {

        chrome.close();

    }


    @Test

    public void searchArticleByArray() {

        chrome.manage().window().maximize();

        chrome.get(HOMEPAGE);

        List<WebElement> articleNames = new ArrayList<WebElement>();

        articleNames = chrome.findElements(ARTICLETITLES);

        boolean articleIsFound = false;

        for (int i = 0; i < articleNames.size(); i++) {

            if (articleNames.get(i).getText().contains(SEARCHEDARTICLE)) {

                articleIsFound = true;
                break;


            }

        }

        Assert.assertTrue("No article found", articleIsFound);


    }


}
