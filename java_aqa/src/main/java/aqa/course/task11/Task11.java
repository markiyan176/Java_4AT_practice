package aqa.course.task11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task11 {
    WebDriver driver;

    //- Navigate to the Demoblaze homepage
    //- Open the product page for Samsung Galaxy S6
    //- Click on the Add to Cart button
    //- Accept the alert confirming the addition
    //- Click on Home to return to the main page
    //- Navigate to the Monitors category
    //- Open the product page for ASUS Full HD
    //-  Click on the Add to Cart button
    //-  Accept the alert confirming the addition
    //-  Go to the Cart page
    //-  Click on Place Order to open the order form
    //-  Fill in the order form with name, country, city, credit card number, month, and year
    //-  Click on Purchase
    //-  Verify that a confirmation alert appears indicating the purchase was successful




    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    void task11Test() throws InterruptedException {

        driver.get("https://www.demoblaze.com");
        Thread.sleep(1000);

        driver.get("https://www.demoblaze.com/prod.html?idp_=1");
        Thread.sleep(1000);

        WebElement addToCartButtonSamsS6 = driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"));
        addToCartButtonSamsS6.click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        WebElement homeButton = driver.findElement(By.xpath("//a[@class='nav-link' and normalize-space(text())='Home']"));
        homeButton.click();
        Thread.sleep(1000);

        WebElement buttonMonitors = driver.findElement(By.xpath("//a[@onclick=\"byCat('monitor')\"]"));
        buttonMonitors.click();
        Thread.sleep(1000);

        WebElement elemAsusFullHD = driver.findElement(By.xpath("//a[normalize-space(text())='ASUS Full HD']"));
        elemAsusFullHD.click();
        Thread.sleep(1000);

        WebElement addToCartButtonAsusHD = driver.findElement(By.xpath("//a[@onclick='addToCart(14)']"));
        addToCartButtonAsusHD.click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        WebElement cartButton = driver.findElement(By.id("cartur"));
        cartButton.click();
        Thread.sleep(1000);

        WebElement buttonAccess = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        buttonAccess.click();
        Thread.sleep(1000);

        driver.findElement(By.id("name")).sendKeys("Name");
        driver.findElement(By.id("country")).sendKeys("Ukraine");
        driver.findElement(By.id("city")).sendKeys("Lviv");
        driver.findElement(By.id("card")).sendKeys("87413");
        driver.findElement(By.id("month")).sendKeys("10");
        driver.findElement(By.id("year")).sendKeys("2025");
        Thread.sleep(1000);

        WebElement buttonPurchaseOrder = driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']"));
        buttonPurchaseOrder.click();
        Thread.sleep(1000);

        WebElement alert = driver.findElement(By.xpath("//*[@class='sweet-alert  showSweetAlert visible']"));
        System.out.println("Alert text:\n" + alert.getText());
        Thread.sleep(1000);
    }


    @AfterTest
    void close() {
        driver.quit();
    }
}
