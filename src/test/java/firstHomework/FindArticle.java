package firstHomework;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindArticle {

    private final String HOMEPAGE = "http://rus.delfi.lv/";

    private String articleName = "Школы переводят";


    @Test
    public void openWebsite() {


        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");

        WebDriver chrome = new ChromeDriver();

        chrome.manage().window().maximize();
        chrome.get(HOMEPAGE);


        WebElement element = chrome.findElement(By.partialLinkText(articleName));

        String fullArticleName = element.getText();

        Assert.assertTrue(fullArticleName.contains(articleName));


    }


}
