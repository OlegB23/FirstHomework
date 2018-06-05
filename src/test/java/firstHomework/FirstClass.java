package firstHomework;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstClass {

    private final String HOMEPAGE = "http://rus.delfi.lv/";

    @Test
    public void openWebsite() {


        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");

        WebDriver chrome = new ChromeDriver();

        chrome.manage().window().maximize();
        chrome.get(HOMEPAGE);


        String articleName = "Латвия согласует";

        WebElement element = chrome.findElement(By.partialLinkText(articleName));

        element.click();


        chrome.close();


    }

}
