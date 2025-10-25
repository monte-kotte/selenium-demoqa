package demoqa.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger logger = LogManager.getLogger();

    public enum BrowserType {
        CHROME,
        FIREFOX
    }

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        WebDriver webDriver = null;
        switch (ConfigWebDriver.getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                logger.info("Chrome web driver created for thread: {}", Thread.currentThread().getId());
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                logger.info("Firefox web driver created for thread: {}", Thread.currentThread().getId());
                break;
            default:
                logger.error("Provided browser type is not supported");
                throw new UnsupportedOperationException("Provided browser type '" + ConfigWebDriver.getBrowserType() + "' is not supported");
        }
        configureWebDriver(webDriver);
        return webDriver;
    }

    private static void configureWebDriver(WebDriver webDriver) {
        setPageLoadTimeout(webDriver);
        setImplicitWait(webDriver);
        maximizeWindow(webDriver);
    }

    private static void setPageLoadTimeout(WebDriver webDriver) {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigWebDriver.getPageLoadTimeout()));
    }

    private static void setImplicitWait(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigWebDriver.getImplicitlyWait()));
    }

    private static void maximizeWindow(WebDriver webDriver) {
        if (ConfigWebDriver.isWindowMaximize()) {
            webDriver.manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            logger.info("Web driver closed for thread: {}", Thread.currentThread().getId());
            driver.remove();
        }
    }

}
