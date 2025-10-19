package aqa.course.task12;

import org.openqa.selenium.WebElement;

public class Element {

    WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        System.out.println("[LOG] Clicking element: " + webElement);
        webElement.click();
    }
}
