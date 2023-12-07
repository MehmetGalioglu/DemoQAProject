package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepBase {
    public Logger logger = LogManager.getLogger(this.getClass());
    public static String red = "\u001b[31b";
    public static String green = "\u001b[32m";
    public static String yellow = "\u001b[33m";
}
