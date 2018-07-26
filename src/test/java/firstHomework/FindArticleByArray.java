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

    public final String HOME_PAGE = "http://rus.delfi.lv";
    public final By ARTICLE_TITLES = By.xpath(".//*[@class='top2012-title']");
    public final String SEARCHED_ARTICLE = "В Москве открыли ЧМ с участием Путина";

    @Before

    public void createDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");
        chrome = new ChromeDriver();
    }

    @Test

    public void searchArticleByArray() {

        chrome.manage().window().maximize();
        chrome.get(HOME_PAGE);
        List<WebElement> articleNames = new ArrayList<WebElement>();
        articleNames = chrome.findElements(ARTICLE_TITLES);
        boolean articleIsFound = false;

        for (int i = 0; i < articleNames.size(); i++) {

            if (articleNames.get(i).getText().equals(SEARCHED_ARTICLE)) {
                articleIsFound = true;
                break;
            }
        }
        Assert.assertTrue("No article found", articleIsFound);
    }

    @After

    public void closeBrowser() {
        chrome.close();
    }
}
