package demoqa.test;

import demoqa.core.driver.DriverManager;
import demoqa.core.page.ElementsPage;
import demoqa.core.page.TextBoxPage;
import demoqa.test.service.ElementsService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver webDriver;
    protected ElementsPage elementsPage;
    protected TextBoxPage textBoxPage;

    protected ElementsService elementsService;

    @BeforeMethod
    public void setUp() {
        webDriver = DriverManager.getInstance();
        initPages();
        initServices();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    private void initPages() {
        elementsPage = new ElementsPage(webDriver);
        textBoxPage = new TextBoxPage(webDriver);
    }

    private void initServices() {
        elementsService = new ElementsService(webDriver);
    }

}
