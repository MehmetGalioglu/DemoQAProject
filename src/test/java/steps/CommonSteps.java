package steps;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonSteps extends Utilities{

    StepBase stepBase = new StepBase();
    Date currentDate = new Date();
    String screenShotFileName = currentDate.toString().replace(" ","-").replace(":","-");


    @Before
    public void before(Scenario scenario){
        System.out.println("Running " + scenario.getName());
        Driver.setup();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            stepBase.logger.error(StepBase.red + scenario.getName() + " is failed!");
            //System.out.println(StepBase.red + scenario.getName() + " is failed!");
            Driver.srcFile = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(Driver.srcFile, new File("C:\\Users\\User\\IdeaProjects\\DemoQAProject\\src\\test\\resources\\screenshots"
                    +screenShotFileName + ".png"));
            stepBase.logger.error(StepBase.red + "Taking screenshot!");
            //System.out.println(StepBase.red + "Taking screenshot!");
        }
        else System.out.println(scenario.getName() + " passed!");

        Driver.terminate();
    }

    @Given("Navigate to {}")
    public void navigate(String url){
        Driver.driver.get(url);
        System.out.println("Navigating to " +url);
    }

    @Given("Wait for {} seconds")
    public void wait(int seconds){
        System.out.println("Waiting for " +seconds + " seconds");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignored) {}
    }


}
