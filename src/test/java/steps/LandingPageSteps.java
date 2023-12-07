package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import pages.LandingPage;

public class LandingPageSteps {
    LandingPage landingPage = new LandingPage();
    @Given("Click card named {} from the LandingPage")
    public void clickCard(String cardName){
        try {
            WebElement card = landingPage.getElementFromList(cardName, landingPage.cards);
            landingPage.elementClick(card,false);
        } catch (StaleElementReferenceException ignored){}
    }

}
