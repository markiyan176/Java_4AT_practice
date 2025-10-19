package task10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    void setup() {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    void task10Test() throws InterruptedException {
        driver.get("https://www.demoblaze.com/prod.html?idp_=1");
        Thread.sleep(1000);

        WebElement addToCartButton = driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"));
        WebElement homeLink = driver.findElement(By.id("nava"));
        WebElement productTitle = driver.findElement(By.xpath("//h2[@class='name']"));
        WebElement homeButton = driver.findElement(By.xpath("//a[@class='nav-link' and normalize-space(text())='Home']"));





        Assert.assertTrue(addToCartButton.isDisplayed());
        Assert.assertTrue(productTitle.isDisplayed());
        Assert.assertTrue(homeButton.isDisplayed());

        Thread.sleep(1000);
        addToCartButton.click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        homeButton.click();
        Thread.sleep(1000);

        WebElement linkNokiaLumia = driver.findElement(By.xpath("//a[@class='hrefch' and normalize-space(text())='Nokia lumia 1520']"));

        Assert.assertTrue(linkNokiaLumia.isDisplayed());

        linkNokiaLumia.click();
        Thread.sleep(1000);



        System.out.println("Product title: " + productTitle.getText());
    }

    @AfterTest
    void close() {
        driver.quit();
    }
}
