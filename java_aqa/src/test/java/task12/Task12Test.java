package task12;

import aqa.course.task12.DemoblazePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task12Test {

    WebDriver driver;
    DemoblazePage demoblazePage;

    @BeforeTest
    void setup() {
//        WebDriverManager.chromedriver()
//                .driverVersion("141.0.7390.66")
//                .setup();
        WebDriverManager.chromedriver()
//                .driverVersion("141.0.7390.66")
                .setup();


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/prod.html?idp_=1");
        demoblazePage = new DemoblazePage(driver);
    }

    @Test
    void task12Test() throws InterruptedException {
        Thread.sleep(1000);

        demoblazePage.addToCart();
        Thread.sleep(1500);

        Alert alert = driver.switchTo().alert();
        System.out.println("[LOG] Alert text: " + alert.getText());
        alert.accept();
        demoblazePage.validateURL();
    }

    @AfterTest
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}