package demoqa.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private static WebDriver driver;
    public static Logger logger = LogManager.getLogger();

    public enum BrowserType {
        CHROME,
        FIREFOX
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;
        switch (ConfigWebDriver.getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Chrome web driver created");
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("Firefox web driver created");
                break;
            default:
                logger.error("Provided browser type is not supported");
                throw new UnsupportedOperationException("Provided browser type '" + ConfigWebDriver.getBrowserType() + "' is not supported");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigWebDriver.getPageLoadTimeout()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigWebDriver.getImplicitlyWait()));
        if (ConfigWebDriver.isWindowMaximize()) {
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
