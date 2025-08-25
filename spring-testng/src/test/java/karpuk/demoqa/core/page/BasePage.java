package karpuk.demoqa.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class BasePage {

    @Autowired
    protected WebDriver driver;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(driver, this);
    }

}
