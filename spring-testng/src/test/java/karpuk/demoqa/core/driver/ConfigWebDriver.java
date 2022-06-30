package karpuk.demoqa.core.driver;

import java.util.ResourceBundle;

public class ConfigWebDriver {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("driver-" + System.getProperty("driver"));

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
