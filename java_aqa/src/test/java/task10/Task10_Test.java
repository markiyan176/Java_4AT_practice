package task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task10_Test {
    WebDriver driver;

    @BeforeTest
    void setup(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",
                "driver/chromedriver");
//        options.addArguments("--headless=new");

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    void task10test(){

        driver.get("https://www.demoblaze.com/prod.html?idp_=1");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement addToCardButton = driver.findElement(By.xpath("//a[@onclick=\"addToCart(1)\"]"));


        Assert.assertTrue(addToCardButton.isDisplayed());
        addToCardButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
    @AfterTest
    void close(){
        driver.quit();
    }
}
