package aqa.course.task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoblazePage {

    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='nav-link' and normalize-space(text())='Home']")
    A homeButton;

    @FindBy(xpath = "//h2[@class='name']")
    WebElement productTitle;

    public DemoblazePage(WebDriver driver) {
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public void addToCart() {
        System.out.println("[LOG] Clicking Add to cart button");
        addToCartButton.click();
    }

    public void validateURL() {
        String actualURL = homeButton.getURL();
        System.out.println("[LOG] Checking home button URL: " + actualURL);
        Assert.assertEquals(actualURL, "https://www.demoblaze.com/index.html");
    }
}
