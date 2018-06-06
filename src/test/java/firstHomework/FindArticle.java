package firstHomework;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindArticle {

    WebDriver chrome;

    private final String HOMEPAGE = "http://rus.delfi.lv/";

    private String articleName = "Синоптики обещают";



    @Before

    public void createChromeDriver() {

        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");

        chrome = new ChromeDriver();

    }



    @After

    public void closeWebsite() {

        chrome.close();

    }



    @Test
    public void openWebsite() {


        chrome.manage().window().maximize();
        chrome.get(HOMEPAGE);


        WebElement element = chrome.findElement(By.partialLinkText(articleName));

        String fullArticleName = element.getText();

        Assert.assertTrue(fullArticleName.contains(articleName));


    }


}
