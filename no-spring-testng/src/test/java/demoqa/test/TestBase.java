package demoqa.test;

import demoqa.core.driver.DriverManager;
import demoqa.core.page.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver webDriver;
    protected MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        webDriver = DriverManager.getInstance();
        initPages();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    private void initPages() {
        mainPage = new MainPage(webDriver);
    }

}
