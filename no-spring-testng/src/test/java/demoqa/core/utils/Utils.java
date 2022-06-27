package demoqa.core.utils;

import demoqa.core.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils {

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) DriverManager.getInstance())
                .executeScript("arguments[0].scrollIntoView()", element);
    }

}
