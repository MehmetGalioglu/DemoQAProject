package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.SubmissionRow;
import utils.Utilities;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends Utilities {

    @FindBy(id = "close_button_svg")
    public List<WebElement> practiceFormAdBoxes;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "userEmail")
    public WebElement emailTextBox;

    @FindBy(css = ".custom-control-label")
    public List<WebElement> tickBoxes;

    @FindBy(id = "userNumber")
    public WebElement userNumberTextBox;

    @FindBy(id = "dateOfBirthInput")
    public WebElement datePicker;

    @FindBy(css = ".react-datepicker__month-select")
    public WebElement monthSelector;

    @FindBy(css = "[class=\"react-datepicker__month-select\"] option")
    public List<WebElement> months;

    @FindBy(css = ".react-datepicker__year-select")
    public WebElement yearSelector;

    @FindBy(css = "[class=\"react-datepicker__year-select\"] option")
    public List<WebElement> years;

    @FindBy(css = "[class=\"react-datepicker__week\"] [class=\"react-datepicker__day react-datepicker__day--014 react-datepicker__day--weekend\"]")
    public List<WebElement> weekOptions;

    @FindBy(id = "subjectsContainer")
    public WebElement subjectsContainer;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsContainerActive;

    @FindBy(css = "[class=\"subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr\"] div")
    public List<WebElement> subjectList;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureButton;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressTextBox;

    @FindBy(id = "state")
    public WebElement selectStateContainer;

    @FindBy(id = "react-select-3-option-1")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement selectCityContainer;

    @FindBy(id = "react-select-4-option-2")
    public WebElement city;

    @FindBy(id = "submit")
    public WebElement SubmitButton;

    @FindBy(css = ".modal-body tbody tr")
    public List<SubmissionRow> submissionRows;

    public SubmissionRow getSubmissionRow(String label){
        for (SubmissionRow row : submissionRows)
            if (row.getLabel().equals(label)) return row;
        throw new RuntimeException("Row not found");
    }

    public List<String> getLabels(){
        List<String> labels = new ArrayList<>();
        for (SubmissionRow row : submissionRows)
            labels.add(row.getLabel());
        return labels;
    }

}
