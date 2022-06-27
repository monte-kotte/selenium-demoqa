package demoqa.core.driver;

import java.util.ResourceBundle;

public class ConfigWebDriver {

    private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static DriverManager.BrowserType getBrowserType() {
        return DriverManager.BrowserType.valueOf(bundle.getString("driver.browser").toUpperCase());
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
