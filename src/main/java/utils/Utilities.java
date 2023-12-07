package utils;

import com.github.webdriverextensions.WebComponent;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import driver.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class Utilities extends WebComponent {

    public Utilities(){PageFactory.initElements(new WebDriverExtensionFieldDecorator(Driver.driver), this);}

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void elementClick(WebElement element){
        element.click();
    }

    public void elementClick(WebElement element, boolean scroll){
        if (scroll) {
            scrollToElement(element);
            element.click();
        }
    }

    public void fillInput(WebElement element, String key){
        element.sendKeys(key);
    }

    public void fillInput(WebElement element, String key, boolean enter){
        if (enter) element.sendKeys(key + Keys.ENTER);
    }

    public void clearElement(WebElement element){
        element.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
    }

    public WebElement getElementFromList(String elementName, List<WebElement> elements){
        System.out.println("Getting the element named " +elementName + " from the list");
        for (WebElement element : elements){
            if (element.getText().equals(elementName))
                return element;
        } throw new RuntimeException("Element not found!");
    }

    public void setWindowSize(int width, int height){
        System.out.println("Setting window size to width of " +width+ " and height of " +height);
        Driver.driver.manage().window().setSize(new Dimension(width,height));
    }
}
