package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;

import java.util.List;

public class TextBoxPage extends Utilities {

    @FindBy(css = "[class=\"text\"]")
    public List<WebElement> elementsOptions;

    @FindBy(id = "userName")
    public WebElement fullNameBox;

    @FindBy(id = "userEmail")
    public WebElement userEmailBox;

    @FindBy(id = "close_button_svg")
    public List<WebElement> adBoxes;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressBox;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressBox;

    @FindBy(css = "[class=\"text-right col-md-2 col-sm-12\"] button")
    public WebElement submitButton;

    @FindBy(css = ".mb-1")
    public List<WebElement> submittedInfo;

}
