package demoqa.test.service;

import demoqa.core.page.TextBoxPage;
import org.openqa.selenium.WebDriver;

public class BaseService {

    protected WebDriver driver;
    protected TextBoxPage textBoxPage;

    public BaseService(WebDriver driver) {
        this.driver = driver;
        textBoxPage = new TextBoxPage(driver);
    }
}
