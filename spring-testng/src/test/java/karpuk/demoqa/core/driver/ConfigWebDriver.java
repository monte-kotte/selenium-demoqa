package karpuk.demoqa.core.driver;

import java.util.Objects;
import java.util.ResourceBundle;

public class ConfigWebDriver {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("driver-" + getDriver());

    private static String getDriver() {
        return Objects.requireNonNull(
                System.getProperty("driver"),
                "System property 'driver' is not set. You can set it on the command line: -Ddriver=chrome"
        );
    }

    public static WebDriverMngr.BrowserType getBrowserType() {
        return WebDriverMngr.BrowserType.valueOf(bundle.getString("driver.browser").toUpperCase());
    }

    public static boolean isWindowMaximize() {
        return Boolean.parseBoolean(bundle.getString("driver.windowMaximize"));
    }

    public static Long getImplicitlyWait() {
        return Long.parseLong(bundle.getString("driver.implicitlyWait"));
    }

    public static Long getPageLoadTimeout() {
        return Long.parseLong(bundle.getString("driver.pageLoadTimeout"));
    }

}
