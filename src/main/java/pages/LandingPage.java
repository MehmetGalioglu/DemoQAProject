package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;

import java.util.List;

public class LandingPage extends Utilities {
    @FindBy(css = "[class=\"card mt-4 top-card\"]")
    public List<WebElement> cards;

}
