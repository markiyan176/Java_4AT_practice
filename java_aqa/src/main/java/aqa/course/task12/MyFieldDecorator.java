package aqa.course.task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyFieldDecorator implements FieldDecorator {

    private final WebDriver driver;

    public MyFieldDecorator(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!WebElement.class.isAssignableFrom(field.getType()) &&
                !A.class.isAssignableFrom(field.getType())) {
            return null;
        }

        ElementLocator locator = new DefaultElementLocatorFactory(driver).createLocator(field);
        if (locator == null) return null;

        if (WebElement.class.isAssignableFrom(field.getType())) {
            return new org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler(locator);
        } else if (A.class.isAssignableFrom(field.getType())) {
            try {
                WebElement element = locator.findElement();
                return field.getType().getConstructor(WebElement.class).newInstance(element);
            } catch (InstantiationException | IllegalAccessException |
                     InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
