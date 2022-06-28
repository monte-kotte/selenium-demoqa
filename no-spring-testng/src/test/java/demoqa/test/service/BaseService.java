package demoqa.test.service;

import demoqa.core.page.TextBoxPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseService {

    protected WebDriver driver;
    protected TextBoxPage textBoxPage;
    public static Logger logger = LogManager.getLogger();

    public BaseService(WebDriver driver) {
        this.driver = driver;
        textBoxPage = new TextBoxPage(driver);
    }
}
