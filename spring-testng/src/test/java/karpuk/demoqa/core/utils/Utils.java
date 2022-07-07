package karpuk.demoqa.core.utils;

import karpuk.demoqa.core.driver.WebDriverMngr;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils {

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) WebDriverMngr.getInstance())
                .executeScript("arguments[0].scrollIntoView()", element);
    }

    public static void waitAndClickJS(WebElement element) {
        ((JavascriptExecutor) WebDriverMngr.getInstance()).executeScript("arguments[0].click();", element);
    }

}
