package karpuk.demoqa.test.step;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStep {

    @Autowired
    protected WebDriver driver;

    public void openPage(String url){
        driver.get(url);
    }

}
