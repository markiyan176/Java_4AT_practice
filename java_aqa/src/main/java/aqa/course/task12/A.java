package aqa.course.task12;
import org.openqa.selenium.WebElement;
public class A extends Element {

    public A(WebElement webElement) {
        super(webElement);
    }

    public String getURL() {
        String result = webElement.getAttribute("href");
        System.out.println("Element URL = " + result);
        return result;
    }

    @Override
    public void click() {
        System.out.println("[LOG] Clicking on element with URL: " + getURL());
        webElement.click();
    }
}