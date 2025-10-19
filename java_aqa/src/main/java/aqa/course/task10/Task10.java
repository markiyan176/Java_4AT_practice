package aqa.course.task10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.demoblaze.com/prod.html?idp_=1");
        Thread.sleep(1000);

        WebElement addToCartButton = driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"));
        WebElement homeLink = driver.findElement(By.id("nava"));
        WebElement productTitle = driver.findElement(By.xpath("//h2[@class='name']"));

        assert addToCartButton.isDisplayed() : "Add to Cart button is not visible!";
        assert homeLink.isDisplayed() : "Home link is not visible!";
        assert productTitle.isDisplayed() : "Product title is not visible!";

        addToCartButton.click();
        Thread.sleep(1000);

        homeLink.click();
        Thread.sleep(1000);

        System.out.println("Product title text: " + productTitle.getText());

        driver.quit();
    }
}
