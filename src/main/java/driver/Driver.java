package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Driver {
    public static WebDriver driver;
    public static File srcFile;

    public static void setup(){

        Properties properties = new Properties();
        try {properties.load(new FileReader("src/test/resources/test.properties"));}
        catch (IOException e){throw new RuntimeException("Property file does not exist");}

        int frameWidth = Integer.parseInt(properties.getProperty("frame-width"));
        int frameHeight = Integer.parseInt(properties.getProperty("frame-height"));
        boolean maximize = Boolean.parseBoolean(properties.getProperty("maximize", "false"));
        boolean headless = Boolean.parseBoolean(properties.getProperty("headless", "false"));
        boolean browserChoice = Boolean.parseBoolean(properties.getProperty("browser", "false"));

        if (!browserChoice) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (headless) chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (properties.containsValue("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (properties.containsValue("edge")) {
            driver = new EdgeDriver();
        }
        else System.out.println("Provide a valid browser name!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().setSize(new Dimension(frameWidth,frameHeight));
        if (maximize) driver.manage().window().maximize();
    }

    public static void terminate(){driver.quit();}
}
