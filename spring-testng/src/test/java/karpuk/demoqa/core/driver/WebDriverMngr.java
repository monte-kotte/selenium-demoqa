package karpuk.demoqa.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverMngr {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

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
        WebDriver driver = null;
        switch (ConfigWebDriver.getBrowserType()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new UnsupportedOperationException("Provided browser type '" + ConfigWebDriver.getBrowserType() + "' is not supported");
        }
        maximize(driver);
        setImplicitlyWait(driver);
        setPageLoadTimeout(driver);
        return driver;
    }

    public static void quitDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        } catch (Exception e) {
            System.out.println("Can not quit browser");
        }
    }

    private static void maximize(WebDriver driver) {
        if (ConfigWebDriver.isWindowMaximize()) {
            driver.manage().window().maximize();
        }
    }

    private static void setImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(ConfigWebDriver.getImplicitlyWait()));
    }

    private static void setPageLoadTimeout(WebDriver driver) {
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(ConfigWebDriver.getPageLoadTimeout()));
    }

}
