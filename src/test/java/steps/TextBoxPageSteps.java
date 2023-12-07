package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import pages.TextBoxPage;


public class TextBoxPageSteps {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Given("Close all advertisement boxes")
    public void closeAdBoxes(){
        for (WebElement adBox : textBoxPage.adBoxes)
            textBoxPage.elementClick(adBox);
        System.out.println("Closing the adboxes");
    }

    @Given("Click box named {} from the ElementPage")
    public void clickTextBox(String boxName){
        WebElement textBox = textBoxPage.getElementFromList(boxName, textBoxPage.elementsOptions);
        textBoxPage.elementClick(textBox,false);
    }

    @Given("Write {} to username box")
    public void writeFullName(String fullName){
        textBoxPage.fillInput(textBoxPage.fullNameBox, fullName,false);
        System.out.println("Writing " + fullName + " to the full name box");
    }

    @Given("Write {} to email box")
    public void writeEmailAddress(String email){
        textBoxPage.fillInput(textBoxPage.userEmailBox, email,false);
        System.out.println("Writing " + email + " to the email box");
    }

    @Given("Write {} to current address box")
    public void writeCurrentAddress(String currentAddress){
        textBoxPage.fillInput(textBoxPage.currentAddressBox, currentAddress,false);
        System.out.println("Writing " + currentAddress + " to the current address box");
    }

    @Given("Write {} to permanent address box")
    public void writePermanentAddress(String permanentAddress){
        textBoxPage.fillInput(textBoxPage.permanentAddressBox, permanentAddress,false);
        System.out.println("Writing " + permanentAddress + " to the permanent address box");
    }

    @Given("Click submit button on the elements page")
    public void clickSubmitButton(){
        textBoxPage.elementClick(textBoxPage.submitButton,true);
    }

    @Given("Show all the submitted info")
    public void showSubmittedInfo(){
        for (WebElement submittedInfo : textBoxPage.submittedInfo)
            System.out.println(submittedInfo);
        System.out.println("All of the submitted info are displayed!");
    }

}
