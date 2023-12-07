package steps;

import driver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PracticeFormPage;
import utils.TestStore;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class PracticeFormPageSteps extends StepBase{
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    WebDriverWait wait = new WebDriverWait(Driver.driver, Duration.ofSeconds(10));

    /* @Given("Close the ad boxes in the practice form page")
    public void closeAds(){
        for (WebElement adBox : toolsPage.practiceFormAdBoxes) toolsPage.elementClick(adBox);
    } */

    @Given("Write your first name {} in the first name box")
    public void sendFirstName(String firstName){
        practiceFormPage.fillInput(practiceFormPage.firstNameTextBox, firstName);
        TestStore.put("firstName", firstName);
        logger.info("Writing " + firstName + " in the first name box");
    }

    @Given("Write your last name {} in the last name box")
    public void sendLastName(String lastName){
        practiceFormPage.fillInput(practiceFormPage.lastNameTextBox, lastName);
        TestStore.put("lastName", lastName);
        TestStore.put("Student Name", TestStore.get("firstName") + " " + lastName);
        logger.info("Writing " +lastName + " in the last name box");
    }

    @Given("Write your email address {} in the email box")
    public void sendEmailAddress(String emailAddress){
        practiceFormPage.fillInput(practiceFormPage.emailTextBox, emailAddress);
        TestStore.put("Student Email", emailAddress);
        logger.info("Writing " +emailAddress + " in the email box ");
    }

    @Given("Click the gender {} to choose gender")
    public void chooseGender(String gender){
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(gender, practiceFormPage.tickBoxes));
        TestStore.put("Gender", gender);
        logger.info("Choosing gender");
    }

    @Given("Write your 10 digit mobile number {} in the first name box")
    public void sendUserNumber(String userNumber){
        practiceFormPage.fillInput(practiceFormPage.userNumberTextBox, userNumber);
        TestStore.put("Mobile", userNumber);
        logger.info("Writing " +userNumber + " in the mobile phone number box");
    }

    @Given("Click date picker box")
    public void clickDatePickerBox(){
        practiceFormPage.elementClick(practiceFormPage.datePicker);
        logger.info("Clicking date picker box");
    }

    @Given("Click month selection container")
    public void clickMonthSelector(){
        practiceFormPage.elementClick(practiceFormPage.monthSelector);
        logger.info("Clicking month selector");
    }

    @Given("Click {} to choose month of birth")
    public void chooseMonth(String month){
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(month, practiceFormPage.months));
        TestStore.put("month", month);
        logger.info("Choosing month of birth");
    }

    @Given("Click {} to choose year of birth")
    public void chooseYear(String year){
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(year, practiceFormPage.years),true);
        TestStore.put("year", year);
        logger.info("Choosing year of birth");
    }

    @Given("Click {} to choose day of birth")
    public void chooseDay(String day){
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(day, practiceFormPage.weekOptions));
        TestStore.put("day", day);
        TestStore.put("Date of Birth", day + " " + TestStore.get("month") + "," + TestStore.get("year"));
        logger.info("Choosing day of birth");
    }

    @Given("Click to subjects container to choose subjects")
    public void activateSubjectsContainer(){
        practiceFormPage.elementClick(practiceFormPage.subjectsContainer,true);
        logger.info("Clicking subjects container");
    }

    @Given("Write {} and Click subject {} to choose a subject")
    public void chooseSubjects(String key, String subject){
        practiceFormPage.fillInput(practiceFormPage.subjectsContainerActive, key);
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(subject, practiceFormPage.subjectList), true);
        TestStore.put("Subjects", subject);
        logger.info("Choosing subjects");
    }

    @Given("Click {} to choose a hobby")
    public void chooseHobbies(String hobby){
        practiceFormPage.elementClick(practiceFormPage.getElementFromList(hobby, practiceFormPage.tickBoxes),true);
        TestStore.put("Hobbies", hobby);
        logger.info("Choosing hobbies");
    }

    @Given("Click the choose file button to upload a picture")
    public void uploadPicture(){
       WebElement chooseFile = practiceFormPage.uploadPictureButton;
       chooseFile.sendKeys("C:\\Users\\User\\Pictures\\Screenshots\\Ekran Görüntüsü (7).png");
       String pictureName = "Ekran Görüntüsü (7).png";
       TestStore.put("Picture", pictureName);
        logger.info("Uploading a picture");
    }

    @Given("Write your address {} in the current address text box")
    public void writeAddress(String address){
        practiceFormPage.fillInput(practiceFormPage.currentAddressTextBox, address, true);
        TestStore.put("Address", address);
        logger.info("Writing address in the current address text box");
    }

    @Given("Set window size to width of {} and height of {}")
    public void setWindowSmaller(int width, int height){
        practiceFormPage.setWindowSize(width,height);
        logger.info("Setting window smaller");
    }

    @Given("Click select state container to select a state")
    public void clickSelectStateContainer(){
        practiceFormPage.scrollToElement(practiceFormPage.selectCityContainer);
        practiceFormPage.elementClick(practiceFormPage.selectStateContainer, true);
        logger.info("Clicking select state container");
    }

    @Given("Click Uttar Pradesh to choose a state")
    public void chooseState(){
        practiceFormPage.elementClick(practiceFormPage.state, true);
        String state = "Uttar Pradesh";
        TestStore.put("State", state);
        logger.info("Choosing state");
    }

    @Given("Click select city container to select a city")
    public void clickSelectCityContainer(){
        practiceFormPage.elementClick(practiceFormPage.selectCityContainer, true);
        logger.info("Clicking select city container");
    }

    @Given("Click Merrut to choose city")
    public void chooseCity(){
        practiceFormPage.elementClick(practiceFormPage.city, true);
        String city = "Merrut";
        TestStore.put("State and City", TestStore.get("State") + " " + city);
        logger.info("Choosing city");
    }

    @Given("Click submit button")
    public void clickSubmitButton(){
        practiceFormPage.elementClick(practiceFormPage.SubmitButton, true);
        logger.info("Clicking submit button");
    }

    /* @Given("Verify the submitted value of {} on the submission table")
    public void verifySubmittedInfo(String labelText){
        String expectedValue = TestStore.get(labelText).toString();
        String actualValue = practiceFormPage.getSubmissionRow(labelText).getValue();
        Assert.assertEquals("Text is not verified", expectedValue, actualValue);
        logger.info(StepBase.green + labelText + " is verified!");
    } */

    @Given("Verify the submitted information")
    public void verifySubmittedInfo(){
        for (String labelText : practiceFormPage.getLabels()){
            String expectedValue = TestStore.get(labelText).toString();
            String actualValue = practiceFormPage.getSubmissionRow(labelText).getValue();
            Assert.assertTrue(StepBase.red + "Text is not verified", actualValue.contains(expectedValue));
            //Assert.assertEquals("Text is not verified", expectedValue, actualValue);
            logger.info(StepBase.green + labelText + " is verified!");
        }
    }
}
